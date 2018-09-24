package com.twcrone.spacemines.mine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		locations = "classpath:application-test.properties")
public class MineFieldIntegrationTests {

	@Autowired
	private MineFieldRepository repository;

	@Test
	public void getMineFieldByUuid() {
		MineFieldEntity mineField = new MineFieldEntity();
		MineEntity mine = new MineEntity(0, 0, 0);
		mineField.addMine(mine);

		repository.save(mineField);

		Optional<MineFieldEntity> found = repository.findById(mineField.getUuid());

		assert found.isPresent();

	}

	@Test
	public void getTestMineFieldByUuid() {
		Optional<MineFieldEntity> found = repository.findById("TEST");

		assert found.isPresent();
		assert found.get().getMines().size() == 1;
	}
}
