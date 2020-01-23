package com.ferreirae.fooddiary.model;

import javax.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    int calories;

    // the name of this instance variable is used as the mappedBy value in the FoodDiaryEntry class
    @ManyToOne
    FoodDiaryEntry entry;

    public Food() {}

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public void setEntry(FoodDiaryEntry entry) {
        this.entry = entry;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
