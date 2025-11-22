package org.jarviswuod;

import jakarta.persistence.*;

// @Entity(name="Student_table")
@Entity
@Table(name = "random_student_table")
public class Student {

    @Id
    private String name;

    @Transient
    private String rollNo;

    @Column(name = "student_color")
    private int marks;

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

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
