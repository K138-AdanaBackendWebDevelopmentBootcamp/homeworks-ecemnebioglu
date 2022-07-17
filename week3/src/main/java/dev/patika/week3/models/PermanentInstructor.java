package dev.patika.week3.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class PermanentInstructor extends Instructor {

    private int fixedSalary;

    public PermanentInstructor(String name,String adress, String phoneNumber,int fixedSalary) {
        super(name, adress, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }


}
