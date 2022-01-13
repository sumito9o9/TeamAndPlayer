package com.example.teamandplayer.controller;

import com.example.teamandplayer.services.PlayerRepository;
import com.example.teamandplayer.services.TeamRepository;
import com.example.teamandplayer.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {


    @Autowired
    public TeamRepository teamRepository;


    @Autowired
    public PlayerRepository playerRepository;

    @PostMapping("/add")
    public String addteam(@ModelAttribute("team") Team team) {

        team.setName("sumit");
        team.setCreated_at("1900");
        team.setLocation("mumbai");
        Team save = teamRepository.save(team);
        System.out.println(team);
        return save.toString();
    }

    @GetMapping("/delete/{id}")
    public String DeleateTeam(@PathVariable("id") Integer id) {

        Optional<Team> byId = teamRepository.findById(id);
        Team team = byId.get();
        System.out.println(team);
        this.teamRepository.delete(team);
        return team.toString();
    }

    @GetMapping("/view")
    public String ViewTeam(@ModelAttribute("team") Team team) {

        System.out.println(this.teamRepository.findAll());
        return teamRepository.findAll().toString();
    }

    @PutMapping("/update/{id}")
    public String Update(@PathVariable("id") Integer id) {
        Optional<Team> byId = this.teamRepository.findById(id);
        Team team = byId.get();
        team.setLocation("mumbaiqwe");
        Team save = this.teamRepository.save(team);
        return save.toString();
    }
}
