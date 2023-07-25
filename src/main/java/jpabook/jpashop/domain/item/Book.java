package jpabook.jpashop.domain.item;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter @Setter
@DiscriminatorValue(value = "B")
public class Book extends Item{

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;
}
