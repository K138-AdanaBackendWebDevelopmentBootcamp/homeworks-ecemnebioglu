package dev.patika.week3.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "coursename")
    private String courseName;
    @Column(name = "coursecode")
    private String courseCode;
    @Column(name = "creditscore")
    private int creditScore;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;
}
