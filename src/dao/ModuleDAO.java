package dao;

import entities.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ModuleDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("linkToMyDb");

    public void persistModule(Module module){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(module);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Module> getAllModules() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<Module> modules = (List) em.createNamedQuery("Module.getAll").getResultList();
        em.close();

        return modules;
    }

    public void mergeModule() {

    }

    public void removeModule() {

    }

}