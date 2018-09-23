package com.example.spacemines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
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
		MineField mineField = new MineField();
		Mine mine = new Mine(0, 0, 0);
		mineField.addMine(mine);

		repository.save(mineField);

		Optional<MineField> found = repository.findById(mineField.getUuid());

		assert found.isPresent();

	}

}
