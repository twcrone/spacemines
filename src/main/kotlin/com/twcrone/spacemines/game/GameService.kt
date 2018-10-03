package com.twcrone.spacemines.game

import com.twcrone.spacemines.mine.MineFieldRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class GameService {

    @Autowired
    lateinit var gameRepository: GameRepository

    @Autowired
    lateinit var mineFieldRepository: MineFieldRepository

    @Transactional
    fun create(mineFieldUuid: String): Game {
        val results = mineFieldRepository.findById(mineFieldUuid)
        val mineField = results.orElseThrow({
            throw IllegalArgumentException("Invalid mine field UUID=$mineFieldUuid") })
        mineField.mines
        val game = Game(mineField)
        gameRepository.save(game)
        return game
    }

    fun get(uuid: String): Game {
        return gameRepository.findById(uuid)
                .orElseThrow({ throw EntityNotFoundException("Game not found with that UUID=$uuid") })
    }

    fun list(): List<String> {
        val found = gameRepository.findAll()
        return found.map { it.uuid }
    }

    fun reveal(game: Game, x: Int, y: Int, z: Int): Game {
        if(game.hasMineAt(x, y, z)) {
            game.end()
            gameRepository.save(game)
        }

        return game
    }
}