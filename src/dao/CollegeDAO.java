package dao;

import entities.College;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CollegeDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistCollege(College college){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(college);

        entityManager.getTransaction().commit();
        entityManager.close();
    }



}
