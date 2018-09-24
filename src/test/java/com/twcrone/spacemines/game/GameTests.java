package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineFieldEntity;
import org.junit.Test;

public class GameTests {

	@Test
	public void createAGameFromMineField() {

		MineFieldEntity mineField = new MineFieldEntity();
		GameEntity game = new GameEntity(mineField);

		assert game.getSphereCount() == 27;
	}

}
