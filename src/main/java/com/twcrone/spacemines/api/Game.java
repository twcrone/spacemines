package com.twcrone.spacemines.api;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String uuid;
    private List<GameSphere> spheres = new ArrayList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<GameSphere> getSpheres() {
        return spheres;
    }

    public void setSpheres(List<GameSphere> spheres) {
        this.spheres = spheres;
    }
}
