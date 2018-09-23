package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "game_uuid")
    private final List<GameSphere> mineSpheres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_field_uuid")
    private final MineField mineField;

    public Game(MineField mineField) {
        this.mineField = mineField;
    }

    @Transient
    public int getSphereCount() {
        if(mineSpheres.size() > 0) {
            return mineSpheres.size();
        }
        else {
            return mineField.getxLength() * mineField.getyLength() * mineField.getzLength();
        }
    }
}
