package com.twcrone.spacemines.api;

import com.twcrone.spacemines.game.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> getAllGameUuids() {

        List<String> results = gameService.listUuids();

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}
