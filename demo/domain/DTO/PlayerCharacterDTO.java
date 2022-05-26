package com.example.demo.domain.DTO;

import com.example.demo.domain.entity.Player;
import com.example.demo.domain.entity.PlayerCharacter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCharacterDTO {
    private int id;
    private String charName;
    private Player player_ID;

    public PlayerCharacterDTO(PlayerCharacter pc) {
        this.id = pc.getId();
        this.charName = pc.getCharName();
        this.player_ID = pc.getPlayer_ID();
    }
}
