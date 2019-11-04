//Gabiel Lupu c15712195  DT354/ year 4
//It should be able to create, merge and remove all objects

package dao;

import entities.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    //Drop table
    public void dropModuleTables() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query q = entityManager.createNativeQuery("DROP TABLE module ");
        q.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public void mergeModule() {

    }

    public void removeModule() {

    }


}