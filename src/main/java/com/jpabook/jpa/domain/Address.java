package com.jpabook.jpa.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

//내장될수있는 것을 알리는 annotation
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // jpa 가 리플렉션을 구현하기 위해 필요한 내용
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
