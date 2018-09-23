package com.twcrone.spacemines.api;

import com.twcrone.spacemines.game.GameEntity;
import com.twcrone.spacemines.game.GameRepository;
import com.twcrone.spacemines.mine.MineField;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GameController {

    private GameRepository repository;

    public GameController(GameRepository gameRepository) {
        this.repository = gameRepository;
    }

    @GetMapping(value = "/game/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Game> getGame(@PathVariable String uuid) {

        Optional<GameEntity> results = repository.findById(uuid);

        return results.map(gameEntity -> new ResponseEntity<>(from(gameEntity), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Game> createGame(@RequestBody CreateGameRequest request) {

        GameEntity game = new GameEntity(new MineField());

        return new ResponseEntity<>(from(game), HttpStatus.CREATED);
    }


    private static Game from(GameEntity entity) {
        Game game = new Game();

        game.setUuid(entity.getUuid());

        game.setSpheres(entity.getSpheres().stream()
                    .map(s -> new GameSphere(s.getX(), s.getY(), s.getZ(), s.getRadiation()))
                    .collect(Collectors.toList()));

        return game;
    }
}
