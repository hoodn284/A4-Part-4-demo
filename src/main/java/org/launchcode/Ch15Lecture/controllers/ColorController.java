package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.ColorRepository;
import org.launchcode.Ch15Lecture.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("color")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("colors", colorRepository.findAll());
        return "color/index";
    }

    @GetMapping("add")
    public String displayAddColorForm(Model model) {
        model.addAttribute("color", new Color());
        return "color/add";
    }

    @PostMapping("add")
    public String processAddColorForm(Model model, @ModelAttribute @Valid Color colorObj,
                                      Errors errors) {

        if (errors.hasErrors()) {
            return "color/add";
        }

        colorRepository.save(colorObj);

        return "redirect:";
    }

    @GetMapping("view/{colorId}")
    public String displayViewColor(Model model, @PathVariable int colorId) {

        Optional optColor = colorRepository.findById(colorId);
        if (optColor.isPresent()) {
            Color color = (Color) optColor.get();
            model.addAttribute("Color", color);
            return "colors/view";
        } else {
            return "redirect:../";
        }

    }

}
