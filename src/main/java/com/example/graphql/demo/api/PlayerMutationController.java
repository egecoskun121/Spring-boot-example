package com.example.graphql.demo.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.demo.entity.Player;
import com.example.graphql.demo.repo.PlayerRepository;
import com.example.graphql.demo.dto.Playerdto;
import graphql.GraphQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerMutationController implements GraphQLMutationResolver {

    private final PlayerRepository playerRepository;

    public Player createPlayer(Playerdto playerdto){
     return playerRepository.save(playerToEntity(playerdto));
    }
    public Player deletePlayer(Playerdto playerdto){
        Player player = playerRepository.getByName(playerdto.getName());
        Optional<Player> targetPlayer = playerRepository.findById(player.getId());
        if(targetPlayer.isPresent()){
            playerRepository.delete(player);
            return player;
        }else {
            throw new GraphQLException("That player "+player.getName()+" does not exists.");
        }
    }
    private Player playerToEntity(Playerdto playerdto){
        Player player = new Player();
        player.setName(playerdto.getName());
        player.setLastName(playerdto.getLastName());
        player.setPosition(playerdto.getPosition());
        return player;

    }

}
