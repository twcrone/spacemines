package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
    public Game create(String mineFieldUuid) {
        Optional<MineField> results = mineFieldRepository.findById(mineFieldUuid);
        MineField mineField = results.orElseThrow(() -> new IllegalArgumentException("Invalid mine field specified"));
        mineField.getMines();
        Game game = new Game(mineField);
        gameRepository.save(game);
        return game;
    }

    public List<String> listUuids() {
        Iterable<Game> found = gameRepository.findAll();
        List<String> uuids = new ArrayList<>();
        found.forEach(game -> uuids.add(game.getUuid()));
        return uuids;
    }
}
