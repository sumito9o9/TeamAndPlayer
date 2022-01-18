package com.example.teamandplayer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//player Entity
@Entity
@Getter
@Setter
public class Player {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String created_at;
    private String updated_at;
    // player mapping to team
    @ManyToOne
    @JsonIgnore
    private Team team;
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
