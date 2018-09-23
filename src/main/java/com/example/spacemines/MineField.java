package com.example.spacemines;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MineField {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uuid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mine_field_uuid")
    private final List<Mine> mines = new ArrayList<>();

    public String getUuid() {
        return uuid;
    }

    public void addMine(Mine mine) {
        mines.add(mine);
    }

}
