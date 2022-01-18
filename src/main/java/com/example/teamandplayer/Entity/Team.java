package com.example.teamandplayer.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
// team entity
@Entity
@Getter
@Setter
public class Team {
    // Id of team AutoGenerated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String location;
    private String created_at;
    private String updated_at;

    // Player mapping to team
    @OneToMany(cascade= CascadeType.ALL,mappedBy = "team")
    private List<Player> players=new ArrayList<>();
    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
