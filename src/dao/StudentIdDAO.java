package dao;

import entities.StudentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentIdDAO {

    //creaza conexiune cu persistence.xml
    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistStudentId(StudentId studentId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(studentId);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
