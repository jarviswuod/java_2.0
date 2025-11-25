package org._07_CachingLevel_2.jarviswuod.jarviswuod;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
public class Student {

    @Id
    private int rollNo;
    private String name;
    private int marks;

    @OneToMany(mappedBy = "student")
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

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
