package org.launchcode.Ch15Lecture.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dinosaur {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min=3)
    private String species;

    @NotNull
    private String diet;

    @NotNull
    private String aquatic;

    public Dinosaur() { }

    public Dinosaur(String species, String diet, String aquatic) {
        this.species = species;
        this.diet = diet;
        this.aquatic = aquatic;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getAquatic() {
        return aquatic;
    }

    public void setAquatic(String aquatic) {
        this.aquatic = aquatic;
    }

    public int getId() {
        return id;
    }
}
