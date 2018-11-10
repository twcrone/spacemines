package com.twcrone.spacemines.game

import com.twcrone.spacemines.mine.Mine
import com.twcrone.spacemines.mine.MineField
import org.junit.Assert.*
import org.junit.Test


class GameTests {

    @Test
    fun `create a game from a mine field`() {
        val mineField = MineField()
        val game = Game(mineField)

        assert(game.sphereCount == 27)
    }

    @Test
    fun `reveal a sphere in game that hits mine ends the game`() {
        val mineField = MineField();
        val mine = Mine(1, 1, 1)
        mineField.addMine(mine)
        val game = Game(mineField)
        val revealed = game.reveal(1, 1, 1)

        assertTrue(revealed.isOver)
        assertTrue(revealed.spheres.isEmpty())
    }

    @Test
    fun `reveal a sphere in game that does NOT hit a mine, returns `() {
        val mineField = MineField()
        val mine = Mine(1, 1, 1)
        mineField.addMine(mine)
        val game = Game(mineField)
        val revealed = game.reveal(0, 0, 0)

        assertFalse(revealed.isOver)
        assertFalse(revealed.spheres.isEmpty())
    }


}