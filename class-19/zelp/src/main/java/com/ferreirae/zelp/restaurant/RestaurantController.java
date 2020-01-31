package com.ferreirae.zelp.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantRepository potato;

    @GetMapping("/restaurants")
    public String getAllRestaurants(Model m) {
        List<Restaurant> restaurants = potato.findAll();
        System.out.println(restaurants);
        m.addAttribute("restaurants", restaurants);
        return "restaurants";
    }

    // javascript!
    // app.get('/restaurants/:id', (req, res) => {
    //   let sql = 'SELECT * FROM restaurant WHERE id = $1';
    //   let values = [req.params.id];
    //   client.query(sql, values).then( dbData => {
    //     let m = { restaurant: dbData.rows[0] };
    //     res.render('restaurant', m)
    //   });
    // });
    //
    @GetMapping("/restaurants/{id}")
    public String getRestaurant(Model m, @PathVariable Long id) {
        Restaurant r = potato.getOne(id);
        // m is like a HashMap for whatever data we want to be passed to the template
        m.addAttribute("restaurant", r);
        return "restaurant";
    }

    @PutMapping("/restaurants/{id}")
    public RedirectView updateRestaurant(@PathVariable Long id, String name, int price) {
        Restaurant r = potato.getOne(id);
        r.setName(name);
        r.setPrice(price);
        System.out.println(potato.save(r));
        return new RedirectView("/restaurants/" + id);
    }
}
