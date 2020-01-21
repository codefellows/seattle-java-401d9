package com.ferreirae.fooddiary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;

@Controller
public class FoodDiaryController {

    @GetMapping("/")
    public String getHome(Model m) {
        // m is the tool that we use to pass data into our template for rendering
        m.addAttribute("username", "Michelle");

        // tomorrow, we'll grab diary entries from the database
        // but for now, we'll just render 3 hardcoded entries.
        FoodDiaryEntry[] entries = new FoodDiaryEntry[] {
          new FoodDiaryEntry("Flaming Hot Cheetos", Date.valueOf("2020-01-20"), 10000, "these were delicious"),
          new FoodDiaryEntry("yogurt", Date.valueOf("2020-01-12"), 180, "yum")
        };
        m.addAttribute("entries", entries);
        return "home";
    }
}
