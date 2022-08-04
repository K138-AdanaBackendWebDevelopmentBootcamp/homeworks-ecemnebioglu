import controller.StudentController;
import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {

        if (checkTestData() == 0) {
            saveTestData();
        }

        StudentController studentController = new StudentController();

        List<Student> studentList = studentController.findAllStudents();

        for(Student student : studentList){
            System.out.println(student);
        }
    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student ", Student.class).getResultList().size();
    }

    private static void saveTestData() {
        Student student1 = new Student("Lee Tiger","male");
        Student student2 = new Student("Donna Whites","female");
        Student student3 = new Student("William Klaus","male");
        Student student4 = new Student("Belle Jour","female");
        Student student5 = new Student("John Specter","male");
        Student student6 = new Student("Rachel Fill","female");

        Course course1 = new Course("Statistics", "S101",5);
        Course course2 = new Course("Mathematic", "M101",8);
        Course course3 = new Course("Physic", "P101",6);

        Instructor permanentInstructor1 = new PermanentInstructor("Blair Green","New Marston","078954652",4500);
        Instructor permanentInstructor2 = new PermanentInstructor("Aurora Nore","New Marston","078954652",5000);
        Instructor visitingResearcher1 = new VisitingResearcher("Andreas Noches", "New Marston","052568435",200);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher1);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course2.getStudentList().add(student3);
        course2.getStudentList().add(student4);
        course3.getStudentList().add(student5);
        course3.getStudentList().add(student6);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);

            em.persist(permanentInstructor1);
            em.persist(permanentInstructor2);
            em.persist(visitingResearcher1);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
