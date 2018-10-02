package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import org.junit.Test;

public class GameTests {

	@Test
	public void createAGameFromMineField() {

		MineField mineField = new MineField();
		Game game = new Game(mineField);

		assert game.getSphereCount() == 27;
	}

}
