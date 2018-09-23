package com.twcrone.spacemines;

import com.twcrone.spacemines.player.Player;
import com.twcrone.spacemines.player.PlayerRepository;
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
public class DemoApplicationTests {


    @Autowired
    PlayerRepository playerRepository;

	@Test
	public void contextLoads() {

	    Player player = new Player("Bob", "bob");

	    playerRepository.save(player);

	    Optional<Player> found = playerRepository.findById(player.getUuid());

	    assert found.isPresent();

	}

}
