package com.ferreirae.dragons;

import com.ferreirae.dragons.models.ApplicationUser;
import com.ferreirae.dragons.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // This can be autowired because there is a bean in our WebSecurityConfig.
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String getHome(Principal p) {
        if(p != null) {
            System.out.println(p.getName());
        } else {
            System.out.println("nobody is logged in");
        }
        return "home";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/signup")
    public RedirectView signup(String username, String password, String firstname) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstname);
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }
}
