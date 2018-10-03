package com.twcrone.spacemines.mine;

import org.junit.Test
import org.junit.Assert.*

class MineFieldTests {

	@Test
	fun `create a minefield with dimensions`() {

		val mineField = MineField(3, 3, 3)

		assertEquals(3, mineField.getxLength())
	}

}
