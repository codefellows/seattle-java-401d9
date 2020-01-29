package com.ferreirae.dragons.models;

import javax.persistence.*;

@Entity
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    boolean canBreatheFire;
    String color;
    int horns;

    @ManyToOne
    ApplicationUser user;

    public Dragon () {}

    public Dragon(boolean canBreatheFire, String color, int horns, ApplicationUser user) {
        this.canBreatheFire = canBreatheFire;
        this.color = color;
        this.horns = horns;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public boolean isCanBreatheFire() {
        return canBreatheFire;
    }

    public String getColor() {
        return color;
    }

    public int getHorns() {
        return horns;
    }
}
