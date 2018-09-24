package com.twcrone.spacemines.game;

import com.twcrone.spacemines.api.GameRep;
import com.twcrone.spacemines.mine.MineFieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    GameRep create(String mineFieldUuid) {
        return null;
    }
}
