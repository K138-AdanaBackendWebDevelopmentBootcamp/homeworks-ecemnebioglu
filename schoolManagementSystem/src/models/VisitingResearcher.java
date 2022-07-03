package models;

import javax.persistence.Entity;

@Entity

public class VisitingResearcher extends Instructor {

    private int hourlySalary;

    public VisitingResearcher(String name, String adress, String phoneNumber, int hourlySalary) {
        super(name, adress, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {

    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "models.VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
