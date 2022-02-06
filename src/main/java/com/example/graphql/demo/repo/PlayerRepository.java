package com.example.graphql.demo.repo;

import com.example.graphql.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {



    List<Player> getByPosition(String position);
    Player getByName(String name);



}
