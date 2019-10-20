package dao;

import entities.Identification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IdentificationDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistIdentification(Identification identification){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(identification);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
