package org._04_relations.jarviswuod;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private String name;
    private String rollNo;
    private int marks;

    // @OneToOne
    // private Laptop laptop;

    // @OneToMany(mappedBy = "student")
    // private List<Laptop> laptops = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private List<Laptop> laptops = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
