package com.example.graphql.demo.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.demo.entity.Player;
import com.example.graphql.demo.repo.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerController implements GraphQLQueryResolver {

    private final PlayerRepository playerRepository;

    public List<Player> getPlayersAll(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByPosition(String position){
        return playerRepository.getByPosition(position);
    }
    public Player getPlayerByName(String name){
    return playerRepository.getByName(name);
    }

    public Optional<Player> getById(Long id){
        return playerRepository.findById(id);
    }
}
