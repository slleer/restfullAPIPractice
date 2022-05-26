package com.example.demo.repository.player;

import com.example.demo.domain.DTO.PlayerDTO;
import com.example.demo.domain.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepositoryCustom {
    Player getPlayerByUserName(String uName);
    List<Player> getAllPlayers();

    Player insertPlayer(String uName, String name);

    Player getPlayerById(int id);

    Player updatePlayerNameById(int id, String name);

    void deletePlayerById(int id);

}
