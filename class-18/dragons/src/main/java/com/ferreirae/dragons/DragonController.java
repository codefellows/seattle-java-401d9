package com.ferreirae.dragons;

import com.ferreirae.dragons.models.ApplicationUser;
import com.ferreirae.dragons.models.ApplicationUserRepository;
import com.ferreirae.dragons.models.Dragon;
import com.ferreirae.dragons.models.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class DragonController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    DragonRepository dragonRepository;

    @PostMapping("/dragons")
    public RedirectView createDragon(int horns, String color, boolean canBreatheFire, Principal p) {
        Dragon dragon = new Dragon(canBreatheFire, color, horns, applicationUserRepository.findByUsername(p.getName()));
        //save dragon
        dragonRepository.save(dragon);
        return new RedirectView("/");
    }

    @DeleteMapping("/dragons/{id}")
    public RedirectView deleteDragon(@PathVariable long id, Principal p) {
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
        Dragon d = dragonRepository.getOne(id);

        // makes sure that the logged in user is the owner of the dragon to be deleted
        if(loggedInUser.getDragons().contains(d)) {
            dragonRepository.deleteById(id);
        }
        return new RedirectView("/");
    }
}
