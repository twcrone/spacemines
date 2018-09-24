package com.twcrone.spacemines.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameRep {
    private String uuid;
    private List<GameSphereRep> spheres = new ArrayList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<GameSphereRep> getSpheres() {
        return spheres;
    }

    public void setSpheres(List<GameSphereRep> spheres) {
        this.spheres = spheres;
    }
}
