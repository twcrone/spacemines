package com.twcrone.spacemines.game

import com.twcrone.spacemines.mine.MineField
import org.junit.Test


class GameTests {

    @Test
    fun `create a game from a mine field`() {
        val mineField = MineField()
        val game = Game(mineField)

        assert(game.sphereCount == 27)
    }
}