package models;

import javax.persistence.Entity;

@Entity

public class PermanentInstructor extends Instructor {
    private int fixedSalary;

    public PermanentInstructor(String name, String adress, String phoneNumber, int fixedSalary) {
        super(name, adress, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(int fixedSalary) {
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

    @Override
    public String toString() {
        return "models.PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
