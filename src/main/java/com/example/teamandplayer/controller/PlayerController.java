package com.example.teamandplayer.controller;

import com.example.teamandplayer.services.PlayerRepository;
import com.example.teamandplayer.services.TeamRepository;
import com.example.teamandplayer.Entity.Player;
import com.example.teamandplayer.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public PlayerRepository playerRepository;

    @PostMapping("/add/{id}")
    public String AddPlayer(@ModelAttribute("player")Player player,@PathVariable("id") Integer id){
        player.setName("sks");
        Optional<Team> byId = this.teamRepository.findById(id);
        Team team = byId.get();
        player.setTeam(team);
        this.playerRepository.save(player);
        return this.playerRepository.save(player).toString();
    }
    @GetMapping("/view")
    public String Viewplayer(){
        List<Player> all = this.playerRepository.findAll();
        return all.toString();

    }
    @GetMapping("/delete/{id}")
    public  String DeletePlayer(@PathVariable("id") Integer id){
        Optional<Player> byId = this.playerRepository.findById(id);
        Player player = byId.get();
        this.playerRepository.delete(player);
        return player.getName().toLowerCase();

    }
    @PutMapping("/update/{id}")
    public String Update(@PathVariable("id") Integer id){
        Optional<Player> byId = this.playerRepository.findById(id);
        Player player = byId.get();
        player.setAge(25);
        this.playerRepository.save(player);
        return this.playerRepository.save(player).toString();

    }

}
