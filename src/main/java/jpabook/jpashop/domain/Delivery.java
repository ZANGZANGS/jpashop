package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Orders orders;
}
