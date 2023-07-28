package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    /**
     * 값 타입은 생성만 되고, 변경이 안되게 해야한다.
     */
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "zipcode")
    private String zipcode;

    @Builder
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
