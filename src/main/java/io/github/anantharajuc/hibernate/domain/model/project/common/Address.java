package io.github.anantharajuc.hibernate.domain.model.project.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address{

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "zipcode")
    String zipcode;

    /*@Column(name = "country")
    String country;*/
}
