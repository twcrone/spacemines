package com.twcrone.spacemines.mine;

import org.junit.Test;

public class MineFieldTests {

	@Test
	public void createMineField() {

		MineFieldEntity mineField = new MineFieldEntity(3, 3, 3);

		assert mineField.getxLength() == 3;

	}

}
