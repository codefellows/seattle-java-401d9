package com.ferreirae.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @GetMapping("/")
    @ResponseBody
    public String getHome() {
        return "this is a string";
    }

    @GetMapping("/hello/{world}")
    @ResponseBody
    public String helloWorld(@PathVariable String world) {
        return world.toUpperCase();
    }
}
