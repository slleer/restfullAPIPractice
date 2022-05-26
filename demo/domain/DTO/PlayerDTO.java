package com.example.demo.domain.DTO;

import com.example.demo.domain.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private int id;
    private String username;
    private String name;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.username = player.getUsername();
        this.name = player.getName();
    }
}
