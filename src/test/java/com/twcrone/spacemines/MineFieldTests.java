package com.twcrone.spacemines;

import com.twcrone.spacemines.mine.MineField;
import org.junit.Test;

public class MineFieldTests {

	@Test
	public void createMineField() {

		MineField mineField = new MineField(3, 3, 3);

		assert mineField.getxLength() == 3;

	}

}
