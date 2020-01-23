package com.ferreirae.fooddiary.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class FoodDiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // mappedBy is the name of the instance variable/property from the other class
    @OneToMany(mappedBy = "entry")
    List<Food> foods;
    private Date date;
    private String notes;

    // this is a default constructor
    public FoodDiaryEntry() {}

    public FoodDiaryEntry(Date date, String notes) {
        this.foods = new LinkedList<>();
        this.date = date;
        this.notes = notes;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Date getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    public long getId() {
        return this.id;
    }
}
