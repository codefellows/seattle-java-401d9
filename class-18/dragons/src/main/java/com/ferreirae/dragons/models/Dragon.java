package com.ferreirae.dragons.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    // Something to keep track of all the dragons I have done nice things for
    // https://www.baeldung.com/hibernate-many-to-many
    @ManyToMany
    @JoinTable(
            name = "nice_things",
            joinColumns = { @JoinColumn(name = "doer_id") },
            inverseJoinColumns = { @JoinColumn(name = "receiver_id") }
    )
    List<Dragon> dragonsIHaveDoneNiceThingsFor;
    // Hibernate/JPA will automatically translate this list into the nice_things table
    // because of the JoinTable annotation

    // Something to keep track of all the dragons who have done nice things for me
    @ManyToMany(mappedBy = "dragonsIHaveDoneNiceThingsFor")
    List<Dragon> dragonsWhoHaveDoneNiceThingsForMe;


    // I could use bad variable names... but I would regret it later
    // List<Dragon> helpDragons;
    // List<Dragon> dragons;

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

    public List<Dragon> getDragonsIHaveDoneNiceThingsFor() {
        return this.dragonsIHaveDoneNiceThingsFor;
    }
    public List<Dragon> getDragonsWhoHaveDoneNiceThingsForMe() {
        return this.dragonsWhoHaveDoneNiceThingsForMe;
    }
}
