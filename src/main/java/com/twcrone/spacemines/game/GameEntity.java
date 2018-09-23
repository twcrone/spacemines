package com.twcrone.spacemines.game;

import com.twcrone.spacemines.mine.MineField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "game_uuid")
    private final List<GameSphereEntity> spheres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mine_field_uuid")
    private final MineField mineField;

    public GameEntity(MineField mineField) {
        this.mineField = mineField;
        for(int x = 0; x < mineField.getxLength(); x++) {
            for(int y = 0; y < mineField.getyLength(); y++) {
                for(int z = 0; z < mineField.getzLength(); z++) {
                    this.spheres.add(new GameSphereEntity(x, y, z));
                }
            }
        }
    }

    public String getUuid() {
        return uuid;
    }

    public List<GameSphereEntity> getSpheres() {
        return spheres;
    }

    @Transient
    public int getSphereCount() {
        return spheres.size();
    }
}
