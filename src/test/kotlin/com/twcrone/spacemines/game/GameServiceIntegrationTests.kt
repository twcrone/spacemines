package com.twcrone.spacemines.game

import com.twcrone.spacemines.mine.Mine
import com.twcrone.spacemines.mine.MineField
import com.twcrone.spacemines.mine.MineFieldRepository
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations = ["classpath:application-test.properties"])
class GameServiceIntegrationTests {

	@Autowired
	lateinit var service: GameService

	@Autowired
	lateinit var mineFieldRepository: MineFieldRepository

	@Test
	fun `create a game from a mine field`() {
		val mineField = MineField();
		val mine = Mine(1, 1, 1)
		mineField.addMine(mine)
		mineFieldRepository.save(mineField)

		val game = service.create(mineField.uuid)

        assertEquals(27, game.sphereCount)
	}
}
