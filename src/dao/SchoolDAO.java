//Gabiel Lupu c15712195  DT354/ year 4
//It should be able to create, merge and remove all objects

package dao;

import entities.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SchoolDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("linkToMyDb");

    public void persistSchool(School school) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(school);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public School getById(String query, String param1, int param2) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        School school = (School) em.createNamedQuery(query).setParameter(param1, param2).getSingleResult();

        em.getTransaction().commit();
        em.close();

        return school;
    }


    //List
    public List<School> getAllSchools() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<School> schools = (List) em.createNamedQuery("School.getAll").getResultList();

        em.getTransaction().commit();
        em.close();

        return schools;
    }

    //update Student
    public void updateStudent(School school) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(school);

        em.getTransaction().commit();
        em.close();

    }

    public void deleteSchool(School school) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(school));

        em.getTransaction().commit();
        em.close();

    }
}
