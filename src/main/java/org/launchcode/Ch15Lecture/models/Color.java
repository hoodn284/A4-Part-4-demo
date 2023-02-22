package org.launchcode.Ch15Lecture.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Color extends AbstractEntity {

    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "colors")
    private List<Dinosaur> dinosaurs = new ArrayList<>();

    public Color() { }

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }
}
