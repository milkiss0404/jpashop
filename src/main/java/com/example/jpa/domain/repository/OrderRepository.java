package com.example.jpa.domain.repository;

import com.example.jpa.domain.Order;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class,id);
    }



    public List<Order>findAll(OrderSearch orderSearch){//order와 연관된 member를 조인해
       return em.createQuery("select o from Order o join o.member m"+
                " where o.status = :status and m.name like :name", Order.class)
                .setParameter("status",orderSearch.getOrderStatus())
                .setParameter("name",orderSearch.getMemberName())
                .setMaxResults(1000)// 최대 1000건
                .getResultList();
    }
}
