package dao;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistStudent(Student student){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

