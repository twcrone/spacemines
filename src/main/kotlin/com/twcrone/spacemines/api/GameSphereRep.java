package com.twcrone.spacemines.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameSphereRep {

    private final Integer x;
    private final Integer y;
    private final Integer z;

    private final Integer radiation;

    public GameSphereRep(int x, int y, int z, int radiation) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radiation = radiation;
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

    public Integer getRadiation() {
        return radiation;
    }
}
