package io.github.anantharajuc.hibernate.domain.model.project.common.audit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Simple JavaBean domain object with an id property.
 * Used as a base class for objects needing this property.
 *
 * @author Anantha Raju C
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@FieldDefaults(level= AccessLevel.PRIVATE)
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "Unique identifier of the Contact.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Schema(description = "universally unique identifier.", example = "737174a9-2875-47e9-8dcd-efb352679b2b")
    @Column(name = "uuid", nullable = false, updatable = false, unique = true)
    private String uuid;

    @PrePersist
    private void prePersistBaseEntity() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID().toString();
        }
    }
}
