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

    private Integer x;
    private Integer y;
    private Integer z;

    public GameSphere(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getRadiation() {
        return radiation;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }
}
