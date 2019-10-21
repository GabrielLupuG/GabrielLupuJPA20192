package dao;

import entities.StudentCard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentCardDAO {

    //creaza conexiune cu persistence.xml
    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("linkToMyDb");

    public void persistStudentId(StudentCard studentCard) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(studentCard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<StudentCard> getAllStudentCards() {
        EntityManager em = entityManagerFactory.createEntityManager();

        List<StudentCard> studentCards = (List<StudentCard>) em.createNamedQuery("StudentCard.findAll").getResultList();
        em.close();

        return studentCards;
    }

    public void updateStudentCard(StudentCard studentCard) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(studentCard);

        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudentCard(StudentCard studentCard) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(studentCard));

        em.getTransaction().commit();
        em.close();
    }


}
