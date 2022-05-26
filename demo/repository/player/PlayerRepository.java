package com.example.demo.repository.player;

import com.example.demo.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>, PlayerRepositoryCustom {
}
