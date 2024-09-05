package com.example.jpa.domain.repository;


import com.example.jpa.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String memberName;//회원이름
    private OrderStatus orderStatus;//주문상태 [ORDER,CANCEL]
}
