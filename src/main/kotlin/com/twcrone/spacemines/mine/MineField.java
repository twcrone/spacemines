package com.twcrone.spacemines.mine;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "mine_field")
public class MineField {

    public final static int MINIMUM_DIMENSION = 3;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    private final int xLength;
    private final int yLength;
    private final int zLength;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mine_field_uuid")
    private final List<Mine> mines = new ArrayList<>();

    public MineField() {
        xLength = MINIMUM_DIMENSION;
        yLength = MINIMUM_DIMENSION;
        zLength = MINIMUM_DIMENSION;
    }

    public MineField(int xLength, int yLength, int zLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
    }

    public String getUuid() {
        return uuid;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public int getzLength() {
        return zLength;
    }

    public void addMine(Mine mine) {
        mines.add(mine);
    }

    public List<Mine> getMines() {
        return Collections.unmodifiableList(this.mines);
    }
}
