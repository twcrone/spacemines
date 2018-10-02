package com.twcrone.spacemines.api

import com.twcrone.spacemines.game.Game
import com.twcrone.spacemines.game.KotlinGameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class KotlinGameController {

    @Autowired
    lateinit var kotlinGameService: KotlinGameService

    @GetMapping(value = "/game/{uuid}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGame(@PathVariable uuid: String): ResponseEntity<GameRep> {

        val results = kotlinGameService.get(uuid)
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