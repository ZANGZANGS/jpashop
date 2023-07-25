package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
@DiscriminatorColumn
public abstract class Item {

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
