package com.ferreirae.pokemon;

class Pokemon {
    int level;
    String type;
    String name;

    public Pokemon(int level, String type, String name) {
        this.level = level;
        this.type = type;
        this.name = name;
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
