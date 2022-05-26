package com.example.demo.domain.DTO;
import com.example.demo.domain.entity.CharacterItem;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.PlayerCharacter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterItemDTO {
    private int id;
    private PlayerCharacter character;
    private Item item;
    private int count;
    private boolean isAttuned;

    public CharacterItemDTO(CharacterItem characterItem) {
        this.id = characterItem.getId();
        this.character = characterItem.getCharacter();
        this.item = characterItem.getItem();
        this.count = characterItem.getCount();
        this.isAttuned = characterItem.isAttuned();
    }
}
