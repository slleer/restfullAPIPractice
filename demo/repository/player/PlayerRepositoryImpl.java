package com.example.demo.repository.player;

import com.example.demo.domain.DTO.PlayerDTO;
import com.example.demo.domain.entity.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    @Override
    public Player getPlayerByUserName(String uName) throws NoResultException {
        Query query = em.createQuery("select p from Player p where p.username = ?1");
        query.setParameter(1, uName);
        Player p = (Player)query.getSingleResult();
        return p;
    }

    @Override
    public List<Player> getAllPlayers() throws IllegalStateException{
        return (List<Player>) em.createQuery("FROM Player").getResultList();
    }

    @Override
    @Transactional
    public Player insertPlayer(String uName, String name) throws EntityExistsException {
        Player player = new Player();
        player.setUsername(uName);
        player.setName(name);
        em.persist(player);
        return player;
    }

    @Override
    public Player getPlayerById(int id) throws IllegalArgumentException {
        Player player = em.find(Player.class, id);
        if(player == null)
            throw new EntityNotFoundException();
        return player;
    }

    @Override
    @Transactional
    public Player updatePlayerNameById(int id, String name) throws EntityNotFoundException, IllegalArgumentException{
        Player player = em.getReference(Player.class, id);
        player.setName(name);
        return player;
    }

    @Override
    @Transactional
    public void deletePlayerById(int id) throws IllegalArgumentException {
        Player player = em.find(Player.class, id);
        if(player == null)
            throw new EntityNotFoundException();
        em.remove(player);
    }
}
