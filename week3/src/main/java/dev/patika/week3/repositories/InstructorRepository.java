package dev.patika.week3.repositories;

import dev.patika.week3.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    @Query("from Instructor  i WHERE i.id=?1")
    Instructor findInstructor(int id);

    Instructor findInstructorByName(String name);
}
