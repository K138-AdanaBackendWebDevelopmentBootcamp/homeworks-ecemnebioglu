package dev.patika.week3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity

public class VisitingResearcher extends Instructor {

    private int hourlySalary;

    public VisitingResearcher(String name, String adress, String phoneNumber, int hourlySalary) {
        super(name, adress, phoneNumber);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitingResearcher)) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return hourlySalary == that.hourlySalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
