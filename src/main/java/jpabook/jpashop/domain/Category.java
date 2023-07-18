package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItems;
}
