package com.example.demo.service;

import com.example.demo.domain.DTO.PlayerDTO;
import com.example.demo.domain.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PlayerService {
    PlayerDTO getPlayerByUsername(String uName);
    List<PlayerDTO> getAllPlayers();
    PlayerDTO insertPlayer(String uName, String name);
    PlayerDTO getPlayerById(int id);
    PlayerDTO updatePlayerNameById(int id, String name);
    void deletePlayerById(int id);
}
