package com.example.demo.repository.itemrepository;

import com.example.demo.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>,  ItemRepositoryCustom{
}
