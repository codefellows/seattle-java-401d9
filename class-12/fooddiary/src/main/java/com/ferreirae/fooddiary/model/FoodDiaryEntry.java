package com.ferreirae.fooddiary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class FoodDiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String food;
    private Date date;
    private int calories;
    private String notes;

    // this is a default constructor
    public FoodDiaryEntry() {}

    public FoodDiaryEntry(String food, Date date, int calories, String notes) {
        this.food = food;
        this.date = date;
        this.calories = calories;
        this.notes = notes;
    }

    public String getFood() {
        return food;
    }

    public Date getDate() {
        return date;
    }

    public int getCalories() {
        return calories;
    }

    public String getNotes() {
        return notes;
    }
}
