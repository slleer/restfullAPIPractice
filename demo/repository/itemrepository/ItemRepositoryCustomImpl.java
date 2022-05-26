package com.example.demo.repository.itemrepository;

import com.example.demo.domain.DTO.ItemDTO;
import com.example.demo.domain.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ItemRepositoryCustomImpl  implements ItemRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    @Override
    public ItemDTO getItemByName(String name) {
        Query query = em.createQuery("select i from Item i where i.name = ?1");
        query.setParameter(1, name);
        Item i = (Item)query.getSingleResult();
        return new ItemDTO(i);
    }
}
