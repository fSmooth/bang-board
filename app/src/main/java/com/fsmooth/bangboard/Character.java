package com.fsmooth.bangboard;

/**
 * Created by fonsi on 22/01/17.
 */

public class Character {
    // atributos
    private String name;
    private int lifes;
    private String description;

    // constructores
    public Character(String name, int lifes, String description) {
        this.name = name;
        this.lifes = lifes;
        this.description = description;
    }

    public Character() {
        this(null, 0, null);
    }

    // gettes and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
