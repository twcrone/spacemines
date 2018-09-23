package com.twcrone.spacemines.api;

public class CreateGameRequest {

    private String mineFieldUuid;

    public void setMineFieldUuid(String mineFieldUuid) {
        this.mineFieldUuid = mineFieldUuid;
    }

    public String getMineFieldUuid() {
        return mineFieldUuid;
    }
}
