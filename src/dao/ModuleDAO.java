package dao;

import entities.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModuleDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unt");

    public void persistModule(Module module){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(module);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}