package com.twcrone.spacemines.game

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class KotlinGameService {

    @Autowired
    lateinit var gameRepository: GameRepository

    fun get(uuid: String): Game {
        return gameRepository.findById(uuid)
                .orElseThrow({ throw EntityNotFoundException("Game not found with that UUID=$uuid") })
    }
}