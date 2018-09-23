package com.twcrone.spacemines;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

}
