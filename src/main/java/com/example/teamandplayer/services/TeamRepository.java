package com.example.teamandplayer.services;

import com.example.teamandplayer.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeamRepository extends JpaRepository<Team,Integer> {
}
