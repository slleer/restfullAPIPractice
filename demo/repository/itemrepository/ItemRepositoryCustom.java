package com.example.demo.repository.itemrepository;

import com.example.demo.domain.DTO.ItemDTO;

import javax.persistence.EntityManager;

public interface ItemRepositoryCustom {
    ItemDTO getItemByName(String name);
}
