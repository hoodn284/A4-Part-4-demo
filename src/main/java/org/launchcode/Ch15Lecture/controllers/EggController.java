package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.models.DinoEgg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("egg")
public class EggController {

    // Let's make a method that is designed to display
    // the egg/index view
    @GetMapping
    public String egg() {
        return "egg/index";
    }

    @GetMapping("add")
    public String displayAddEggForm(Model model) {
        model.addAttribute("dinoEgg", new DinoEgg());
        return "egg/add";
    }

    @PostMapping("add")
    public String processAddEggForm() {
        return "";
    }

}
