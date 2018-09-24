package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.Mine;
import com.twcrone.spacemines.mine.MineField;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		locations = "classpath:application-test.properties")
public class GameServiceIntegrationTests {

	@Autowired
	private GameService service;

	@Autowired
	private MineFieldRepository mineFieldRepository;

	@Test
	public void createGame() {
		MineField mineField = new MineField();
		Mine mine = new Mine(1, 1, 1);
		mineField.addMine(mine);
		mineFieldRepository.save(mineField);
	}
}
