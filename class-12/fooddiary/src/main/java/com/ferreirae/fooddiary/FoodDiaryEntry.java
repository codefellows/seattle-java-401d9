package com.ferreirae.fooddiary;

import java.sql.Date;

public class FoodDiaryEntry {

    private String food;
    private Date date;
    private int calories;
    private String notes;

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
