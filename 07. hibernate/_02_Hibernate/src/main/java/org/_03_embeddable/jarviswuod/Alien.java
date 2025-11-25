package org._03_embeddable.jarviswuod;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aid;
    private AlienName alienName;
    private String color;

    public AlienName getName() {
        return alienName;
    }

    public void setName(AlienName alienName) {
        this.alienName = alienName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", alienName=" + alienName +
                ", color='" + color + '\'' +
                '}';
    }
}
