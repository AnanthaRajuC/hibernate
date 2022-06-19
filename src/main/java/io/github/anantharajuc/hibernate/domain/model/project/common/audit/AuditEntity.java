package io.github.anantharajuc.hibernate.domain.model.project.common.audit;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Simple JavaBean domain object with id, created on, created by, updated on, updated by properties.
 * Used as a base class for objects needing this property.
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */
@EntityListeners({AuditingEntityListener.class})
@FilterDefs(@FilterDef(name ="activeFilter", parameters={@ParamDef(name="isActive", type="boolean")}))
@Filters(@Filter(name="activeFilter", condition=":is_active = isActive"))
@Where(clause = "is_active = 1")
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@SuperBuilder

public abstract class AuditEntity extends BaseEntity {
    @Column(name="created_date", nullable=true, updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    Date createdDate;

    @Column(name="last_modified_date", nullable=true, updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    Date lastModifiedDate;

    @Column(name = "is_active", nullable = false)
    Boolean isActive;

    @Column(name = "inactive_reason")
    String inactiveReason;

    @Column(name = "inactive_timestamp")
    Long inactiveTimestamp;

    @PrePersist
    public void prePersist() {
        if (null == this.isActive) {
            this.isActive = Boolean.TRUE;
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (null == this.isActive) {
            this.isActive = Boolean.TRUE;
        }
    }

    public final void deactivate(final String reason) {
        this.isActive = false;
        this.inactiveReason = reason;
        this.inactiveTimestamp = Calendar.getInstance().getTimeInMillis();
    }
}
