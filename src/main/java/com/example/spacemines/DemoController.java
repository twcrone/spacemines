package com.example.spacemines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    PlayerRepository repository;

    @GetMapping(value = "/")
    String home() {
        return "Hello World";
    }

    @GetMapping(value = "/player/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Player> getPlayer(@PathVariable Long id) {

        Optional<Player> optionalPlayer = repository.findById(id);

        return optionalPlayer.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/player", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player created = repository.save(player);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
