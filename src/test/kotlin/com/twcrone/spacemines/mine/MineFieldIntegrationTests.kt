package com.twcrone.spacemines.mine

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

import org.junit.Assert.*

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations = ["classpath:application-test.properties"])
class MineFieldIntegrationTests {

	@Autowired
	lateinit var repository: MineFieldRepository

	@Test
	fun `get a minefield by its UUID`() {
		val mineField = MineField()
		val mine = Mine(0, 0, 0)
		mineField.addMine(mine)

		repository.save(mineField)

		val found= repository.findById(mineField.uuid)

		assertTrue(found.isPresent)
	}

	@Test
	fun `get test minefield by its UUID`() {
		val found = repository.findById("TEST")

		assertTrue(found.isPresent)
		assertEquals(1, found.get().mines.size)
	}
}
