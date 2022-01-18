package com.example.teamandplayer.services;

import com.example.teamandplayer.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

// interface Inheriting ORM ie. Jpa Repository for Crud Operation for Team

public interface TeamRepository extends JpaRepository<Team,Integer> {
}
