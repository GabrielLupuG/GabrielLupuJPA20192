package dao;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistStudent(Student student){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Student> getAllStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Student> students = (List<Student>) entityManager.createQuery("Student.findAll").getResultList();


        //va trebui sa faci o lista de Student in care sa bagi toti studentii precum ai in metoda din StudentCardDAO
        //inainte sa iti faci metoda va trebui ca in Student din entities
        //sa faci un @NamedQuery precum in StudentCard

        entityManager.close();

        return students;
    }

    public void updateStudent(Student studentToMerge) {
        //aici va trebui sa dai merge la un obiect de tip Student
        //pe care il vei trimite din MainActivity.java


    }

    public void deleteStudent(Student studentToRemove) {
        //aici va trebui sa stergi obiectul de tip Student pe care il
        //vei trimite din MainActivity,java
        //ATENTIE!
        //inainte sa dai remove la obiect trebuie sa-i dai merge
        //vezi exemplele din StudentCardDAO
    }

}

