package com.ferreirae.pokemon;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon {

    @PrimaryKey
    public int id;

    @ColumnInfo
    int level;

    @ColumnInfo
    String type;

    @ColumnInfo
    String name;

    public Pokemon(int level, String type, String name) {
        this.level = level;
        this.type = type;
        this.name = name;

        State s = State.ACCEPTED;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
