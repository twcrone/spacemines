package com.twcrone.spacemines.api;

public class CreateGameRequest {

    private final String mineFieldUuid;

    public CreateGameRequest(String mineFieldUuid) {
        this.mineFieldUuid = mineFieldUuid;
    }

    public String getMineFieldUuid() {
        return mineFieldUuid;
    }
}
