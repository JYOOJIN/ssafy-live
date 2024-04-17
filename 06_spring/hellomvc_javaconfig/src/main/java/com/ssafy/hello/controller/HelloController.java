package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    public HelloController() {
        System.out.println("HelloController created");
    }

    @GetMapping(path = "/")
    public String index(Model model) {
        System.out.println("HelloController index() called");
        model.addAttribute("name", "안효인");
        return "index";
    }
}
