package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GameService {

    private final MineFieldRepository mineFieldRepository;
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository,
                       MineFieldRepository mineFieldRepository) {
        this.gameRepository = gameRepository;
        this.mineFieldRepository = mineFieldRepository;
    }

    @Transactional
    Game create(String mineFieldUuid) {
        Optional<MineField> results = mineFieldRepository.findById(mineFieldUuid);
        MineField mineField = results.orElseThrow(() -> new IllegalArgumentException("Invalid mine field specified"));
        mineField.getMines();
        Game game = new Game(mineField);
        gameRepository.save(game);
        return game;
    }
}
