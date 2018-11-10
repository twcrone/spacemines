package com.twcrone.spacemines.api

import com.twcrone.spacemines.game.Game
import com.twcrone.spacemines.game.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
class GameController {

    @Autowired
    lateinit var gameService: GameService

    @PostMapping("/game", consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createGame(@RequestBody request: CreateGameRequest): ResponseEntity<GameRep> {
        val game = gameService.create(request.mineFieldUuid)

        return ResponseEntity(from(game), HttpStatus.CREATED)
    }

    @GetMapping("/game/{uuid}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGame(@PathVariable uuid: String): ResponseEntity<GameRep> {

        val results = gameService.get(uuid)
        return ResponseEntity(from(results), HttpStatus.OK)
    }

    private fun from(entity: Game): GameRep {
        val game = GameRep()

        game.uuid = entity.uuid

        game.spheres = entity.spheres.stream()
                .map { s -> GameSphereRep(s.x, s.y, s.z, s.radiation) }
                .collect(Collectors.toList<GameSphereRep>())

        return game
    }

}