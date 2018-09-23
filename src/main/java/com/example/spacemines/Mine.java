package com.example.spacemines;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Mine {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    private final Integer x;
    private final Integer y;
    private final Integer z;

    public Mine(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getUuid() {
        return uuid;
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
