package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import org.junit.Test;

public class GameTests {

	@Test
	public void createAGameFromMineField() {

		MineField mineField = new MineField(3, 3, 3);
		GameEntity game = new GameEntity(mineField);

		assert game.getSphereCount() == 27;
	}

}
