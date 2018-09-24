package com.twcrone.spacemines.mine;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mine")
public class MineEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    private Integer x;
    private Integer y;
    private Integer z;

    private MineEntity() {}

    public MineEntity(int x, int y, int z) {
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
