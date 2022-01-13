package com.example.teamandplayer.services;

import com.example.teamandplayer.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
