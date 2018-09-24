package com.twcrone.spacemines.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
