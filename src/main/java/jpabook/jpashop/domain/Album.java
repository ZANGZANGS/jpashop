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
@DiscriminatorValue(value = "A")
public class Album extends Item{

    @Column(name = "artist")
    private String artist;

    @Column(name = "etc")
    private String etc;
}
