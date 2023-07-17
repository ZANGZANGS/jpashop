package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private long price;

    @Column(name = "stockQuantity")
    private int stockQuantity;

}
