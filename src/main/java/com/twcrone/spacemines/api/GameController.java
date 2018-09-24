package com.twcrone.spacemines.api;

import com.twcrone.spacemines.game.Game;
import com.twcrone.spacemines.game.GameService;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {

    private GameService gameService;

    private MineFieldRepository mineFieldRepository;

    public GameController(GameService gameService,
                          MineFieldRepository mineFieldRepository) {
        this.gameService = gameService;
        this.mineFieldRepository = mineFieldRepository;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> getAllGameUuids() {

        List<String> results = gameService.listUuids();

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = "/game/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GameRep> getGame(@PathVariable String uuid) {

        Game results = gameService.get(uuid);
        return new ResponseEntity<>(from(results), HttpStatus.OK);
    }

    @PostMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GameRep> createGame(@RequestBody CreateGameRequest request) {

        Game game = gameService.create(request.getMineFieldUuid());

        return new ResponseEntity<>(from(game), HttpStatus.CREATED);
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
