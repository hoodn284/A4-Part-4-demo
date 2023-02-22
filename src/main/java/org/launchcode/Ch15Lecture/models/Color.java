package org.launchcode.Ch15Lecture.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Color extends AbstractEntity {

    @NotBlank
    private String name;

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
}
