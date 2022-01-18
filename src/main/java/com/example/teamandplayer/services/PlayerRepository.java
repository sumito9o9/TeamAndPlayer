package com.example.teamandplayer.services;

import com.example.teamandplayer.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
// interface Inheriting ORM ie. Jpa Repository for Crud Operation for Players
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
