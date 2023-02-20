package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoEggRepository;
import org.launchcode.Ch15Lecture.data.DinosaurRepository;
import org.launchcode.Ch15Lecture.models.DinoEgg;
import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("egg")
public class EggController {

    @Autowired
    private DinosaurRepository dinosaurRepository;

    @Autowired
    private DinoEggRepository dinoEggRepository;

    // Let's make a method that is designed to display
    // the egg/index view
    @GetMapping
    public String egg() {
        return "egg/index";
    }

    @GetMapping("add")
    public String displayAddEggForm(Model model) {
        model.addAttribute("dinoEgg", new DinoEgg());
        model.addAttribute("allDinos", dinosaurRepository.findAll());
        return "egg/add";
    }

    @PostMapping("add")
    public String processAddEggForm(Model model, @ModelAttribute @Valid DinoEgg newDinoEgg,
                                    Errors errors) {

        // First, we check to see if the data in the request is valid for creating
        // a new DinoEgg object. If it isn't valid, we should send the user back to the
        // egg/add page and show the form again
        if (errors.hasErrors()) {
            model.addAttribute("allDinos", dinosaurRepository.findAll());
            return "egg/add";
        }

        // If we have determined that the data is valid, then we need to save our new
        // DinoEgg object to the database
        dinoEggRepository.save(newDinoEgg);

        return "redirect:";
    }

}
