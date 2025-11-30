package org._05_eagerAndLazyLoading.jarviswuod;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int rollNo;
    private String name;
    private int marks;

    // @OneToMany(mappedBy = "student")
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Laptop> laptops = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
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
