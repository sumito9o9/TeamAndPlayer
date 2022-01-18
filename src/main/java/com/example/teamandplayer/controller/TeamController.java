package com.example.teamandplayer.controller;

import com.example.teamandplayer.services.PlayerRepository;
import com.example.teamandplayer.services.TeamRepository;
import com.example.teamandplayer.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
// Controller for Team
@RestController
@RequestMapping("/team")
public class TeamController {


    @Autowired
    public TeamRepository teamRepository;


    @Autowired
    public PlayerRepository playerRepository;
// Endpoint to add Team information
    @PostMapping("/add")
    public String addteam(@ModelAttribute("team") Team team) {

        Team save = teamRepository.save(team);
        System.out.println(team);
        return save.toString();
    }
//Endpoint to Delete the team
    @GetMapping("/delete/{id}")
    public String DeleateTeam(@PathVariable("id") Integer id) {

        Optional<Team> byId = teamRepository.findById(id);
        Team team = byId.get();
        System.out.println(team);
        this.teamRepository.delete(team);
        return team.toString();
    }
// Endpoint to View the team list
    @GetMapping("/view")
    public String ViewTeam(@ModelAttribute("team") Team team) {

        System.out.println(this.teamRepository.findAll());
        return teamRepository.findAll().toString();
    }
// Endpoint to Update Team Information
    @PutMapping("/update/{id}")
    public String Update(@PathVariable("id") Integer id) {
        Optional<Team> byId = this.teamRepository.findById(id);
        Team team = byId.get();
        team.setLocation("mumbaiqwe");
        Team save = this.teamRepository.save(team);
        return save.toString();
    }
}
