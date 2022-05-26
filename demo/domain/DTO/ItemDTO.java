package com.example.demo.domain.DTO;

import com.example.demo.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private int id;
    private String name;
    private boolean consumable;
    private boolean attunement;
    private String description;

    public ItemDTO (Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.consumable = item.getConsumable();
        this.attunement = item.getAttunement();
        this.description = item.getDescription();
    }
}
