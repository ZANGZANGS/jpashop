package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();

}
