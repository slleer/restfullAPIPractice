package com.example.demo.service;

import com.example.demo.domain.DTO.PlayerDTO;
import com.example.demo.domain.entity.Player;
import com.example.demo.repository.player.PlayerRepositoryImpl;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final Log logger = LogFactory.getLog(PlayerServiceImpl.class);
    private final PlayerRepositoryImpl playerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public PlayerServiceImpl(PlayerRepositoryImpl playerRepository, RestTemplate restTemplate) {
        this.playerRepository = playerRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public PlayerDTO getPlayerByUsername(String uName) throws NoResultException {
        try {
            Player player = this.playerRepository.getPlayerByUserName(uName);
            return new PlayerDTO(player);
        } catch (NoResultException e) {
            logger.debug(e);
            throw e;
        }
    }

    @Override
    public List<PlayerDTO> getAllPlayers() throws  IllegalStateException{
        try{
            return this.playerRepository.getAllPlayers().stream().map(p -> new PlayerDTO(p)).collect(Collectors.toList());
        } catch (IllegalStateException e) {
            logger.debug(e);
            throw e;
        }
    }

    @Override
    public PlayerDTO insertPlayer(String uName, String name) throws EntityExistsException {

        try {
            return new PlayerDTO(this.playerRepository.insertPlayer(uName, name));
        } catch (EntityExistsException e) {
            logger.debug(e);
            throw e;
        }
    }

    @Override
    public PlayerDTO getPlayerById(int id) {
        return new PlayerDTO(this.playerRepository.getPlayerById(id));
    }

    @Override
    public PlayerDTO updatePlayerNameById(int id, String name) {
        return new PlayerDTO(this.playerRepository.updatePlayerNameById(id, name));
    }

    @Override
    public void deletePlayerById(int id) {
        this.playerRepository.deletePlayerById(id);
    }
}
