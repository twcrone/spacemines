package com.twcrone.spacemines.api;

import com.twcrone.spacemines.game.Game;
import com.twcrone.spacemines.game.GameRepository;
import com.twcrone.spacemines.mine.MineField;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GameController {

    private GameRepository repository;

    private MineFieldRepository mineFieldRepository;

    public GameController(GameRepository gameRepository,
                          MineFieldRepository mineFieldRepository) {
        this.repository = gameRepository;
        this.mineFieldRepository = mineFieldRepository;
    }

    @GetMapping(value = "/game/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GameRep> getGame(@PathVariable String uuid) {

        Optional<Game> results = repository.findById(uuid);

        return results.map(gameEntity -> new ResponseEntity<>(from(gameEntity), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GameRep> createGame(@RequestBody CreateGameRequest request) {

        Optional<MineField> results = mineFieldRepository.findById(request.getMineFieldUuid());
        Game gameEntity = results.map(Game::new)
                .orElseThrow(() -> new IllegalArgumentException("Not a valid minefield"));

        return new ResponseEntity<>(from(gameEntity), HttpStatus.CREATED);
    }


    private static GameRep from(Game entity) {
        GameRep game = new GameRep();

        game.setUuid(entity.getUuid());

        game.setSpheres(entity.getSpheres().stream()
                    .map(s -> new GameSphereRep(s.getX(), s.getY(), s.getZ(), s.getRadiation()))
                    .collect(Collectors.toList()));

        return game;
    }
}
