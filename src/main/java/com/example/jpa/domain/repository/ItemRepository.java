package com.example.jpa.domain.repository;

import com.example.jpa.domain.item.Item;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){  //item은 빈객체에 있을수가없음 신규면 영.컨 에올리고 업데이트면 머지함
            em.persist(item);
        }else {
            em.merge(item);
        }
    }
    public Item findOne(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i",Item.class)
                .getResultList();
    }



}
