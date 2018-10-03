package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "game_uuid")
    private final List<GameSphere> spheres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_field_uuid")
    private MineField mineField;

    private Game() {}

    public Game(MineField mineField) {
        this.mineField = mineField;
        for(int x = 0; x < mineField.getxLength(); x++) {
            for(int y = 0; y < mineField.getyLength(); y++) {
                for(int z = 0; z < mineField.getzLength(); z++) {
                    this.spheres.add(new GameSphere(x, y, z));
                }
            }
        }
    }

    public String getUuid() {
        return uuid;
    }

    public List<GameSphere> getSpheres() {
        return spheres;
    }

    public boolean hasMineAt(int x, int y, int z) {
        return this.mineField.getMines().stream()
                .anyMatch((mine) ->
                        mine.getX() == x && mine.getY() == y && mine.getZ() == z);
    }

    public Game reveal(int x, int y, int z) {
        if(this.hasMineAt(x, y, z)) {
            this.end();
        }
        else {
            // something else
        }
        return this;
    }

    @Transient
    public int getSphereCount() {
        return spheres.size();
    }

    public boolean isOver() {
        return spheres.isEmpty();
    }

    public void end() {
        spheres.clear();
    }
}
