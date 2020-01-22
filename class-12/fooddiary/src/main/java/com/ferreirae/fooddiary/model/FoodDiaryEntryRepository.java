package com.ferreirae.fooddiary.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDiaryEntryRepository extends JpaRepository<FoodDiaryEntry, Long> {
    public List<FoodDiaryEntry> findByFood(String food);
}
