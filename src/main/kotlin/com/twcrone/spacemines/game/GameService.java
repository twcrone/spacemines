package com.twcrone.spacemines.game;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<String> listUuids() {
        Iterable<Game> found = gameRepository.findAll();
        List<String> uuids = new ArrayList<>();
        found.forEach(game -> uuids.add(game.getUuid()));
        return uuids;
    }
}
