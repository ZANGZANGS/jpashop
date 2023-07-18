package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter @Setter
@DiscriminatorValue(value = "M")
public class Movie extends Item{

    @Column(name = "director")
    private String director;

    @Column(name = "actor")
    private String actor;
}
