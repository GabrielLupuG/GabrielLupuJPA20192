//Gabiel Lupu c15712195  DT354/ year 4
//It should be able to create, merge and remove all objects

package dao;

import entities.StudentCard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentCardDAO {

    // create connection with persistence.xml
    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("linkToMyDb");

    public void persistStudent(StudentCard studentCard) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(studentCard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    //List
    public List<StudentCard> getAllStudentCards() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<StudentCard> studentCards = (List<StudentCard>) em.createNamedQuery("StudentCard.findAll").getResultList();
        em.close();

        return studentCards;
    }


    //update StudentCard
    public void updateStudentCard(StudentCard studentCard) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(studentCard);

        em.getTransaction().commit();
        em.close();
    }


    //delete StudentCard
    public void deleteStudentCard(StudentCard studentCard) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(studentCard));

        em.getTransaction().commit();
        em.close();
    }
}
