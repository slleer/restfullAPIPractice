package com.example.demo.controller;


import com.example.demo.domain.DTO.PlayerDTO;
import com.example.demo.domain.entity.Player;
import com.example.demo.service.PlayerService;
import com.example.demo.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerServiceImpl playerService;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        return new ResponseEntity<>(this.playerService.getAllPlayers(), HttpStatus.OK);
    }
    @GetMapping("/players/id/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable int id) {
        return new ResponseEntity<>(this.playerService.getPlayerById(id), HttpStatus.OK);
    }
    @GetMapping("/players/username/{uName}")
    public ResponseEntity<PlayerDTO> getPlayerByUsername(@PathVariable String uName) {
        return new ResponseEntity<>(this.playerService.getPlayerByUsername(uName), HttpStatus.OK);
    }
    @PostMapping("/players/{username}/{name}")
    public ResponseEntity<PlayerDTO> insertNewPlayer(@PathVariable("username") String uName, @PathVariable("name") String name) {
        return new ResponseEntity<>(this.playerService.insertPlayer(uName, name), HttpStatus.OK);
    }
    @PatchMapping("/players/{id}/{name}")
    public ResponseEntity<PlayerDTO> updatePlayerById(@PathVariable("id") int id, @PathVariable("name") String name) {
        return new ResponseEntity<>(this.playerService.updatePlayerNameById(id, name), HttpStatus.OK);
    }
    @DeleteMapping("/players/{id}")
    public ResponseEntity<PlayerDTO> deletePlayerById(@PathVariable int id) {
        this.playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
