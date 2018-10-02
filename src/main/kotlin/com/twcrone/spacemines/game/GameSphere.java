package com.twcrone.spacemines.game;

import javax.persistence.*;

@Entity
@Table(name = "game_sphere")
public class GameSphere {

    private final static Integer UNKNOWN = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer radiation = UNKNOWN;

    private int x;
    private int y;
    private int z;

    private GameSphere() {}

    public GameSphere(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getRadiation() {
        return radiation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
