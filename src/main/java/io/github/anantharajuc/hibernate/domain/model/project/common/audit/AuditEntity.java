package io.github.anantharajuc.hibernate.domain.model.project.common.audit;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Simple JavaBean domain object with id, created on, created by, updated on, updated by properties.
 * Used as a base class for objects needing this property.
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */


@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@SuperBuilder
public class AuditEntity extends BaseEntity {

    @Column(name="created_date", nullable=true, updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    Date createdDate;

    @Column(name="last_modified_date", nullable=true, updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    Date lastModifiedDate;
}
