package com.example.jpa.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable  //내장시킨다??
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    protected Address(){

    } //@Embeddable은 자바기본생성자를 public또는 protected로 설정해야한다 JPA가 이런제약을 두는 이유ㅜ는
//    JPA 구현 라이브러리가 객체를 생성할때 리플렉션같은 기술을 사용할수있도록 지원해야하기 때문이다

}
