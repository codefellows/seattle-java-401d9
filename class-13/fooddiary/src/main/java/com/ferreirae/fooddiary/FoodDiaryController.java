package com.ferreirae.fooddiary;

import com.ferreirae.fooddiary.model.Food;
import com.ferreirae.fooddiary.model.FoodDiaryEntry;
import com.ferreirae.fooddiary.model.FoodDiaryEntryRepository;
import com.ferreirae.fooddiary.model.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.List;

@Controller
public class FoodDiaryController {

    @Autowired
    FoodDiaryEntryRepository repo;

    @Autowired
    FoodRepository foodRepo;

    @GetMapping("/")
    public String getHome(Model m) {
        // m is the tool that we use to pass data into our template for rendering
        m.addAttribute("username", "Michelle");

        // tomorrow, we'll grab diary entries from the database
        // but for now, we'll just render 3 hardcoded entries.
//        FoodDiaryEntry[] entries = new FoodDiaryEntry[] {
//          new FoodDiaryEntry("Flaming Hot Cheetos", Date.valueOf("2020-01-20"), 10000, "these were delicious"),
//          new FoodDiaryEntry("yogurt", Date.valueOf("2020-01-12"), 180, "yum")
//        };

        // this means a get request is not idempotent
        // do not do this
        // repo.save(entries[0]);

        // grab all the entries from the db
        List<FoodDiaryEntry> entries = repo.findAll();
        //just get a single entry by ID
//        FoodDiaryEntry entry = repo.getOne(1L);
        m.addAttribute("entries", entries);
        return "home";
    }

    @PostMapping("/entries")
    public RedirectView addEntry(String potato, int calories, Date date, String notes) {
        FoodDiaryEntry newEntry = new FoodDiaryEntry(date, notes);
        repo.save(newEntry);
        return new RedirectView("/");
    }

    @PostMapping("/entries/{id}/foods")
    public RedirectView addFood(@PathVariable Long id, String name, int calories) {
        Food food = new Food(name, calories);
        // link food and entry
        FoodDiaryEntry entry = repo.getOne(id);
        food.setEntry(entry);
        foodRepo.save(food);

        return new RedirectView("/");
    }
}
