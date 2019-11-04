package dao;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentDAO {

    protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("linkToMyDb");

    public void persistStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Student> getAllStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Student> students = (List<Student>) entityManager.createNamedQuery("Student.findAll").getResultList();

        entityManager.close();

        return students;
    }

    public void updateStudent(Student student) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();
        em.close();

    }

    public void deleteStudent(Student student) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(student));

        em.getTransaction().commit();
        em.close();
    }

    public void deleteAllStudents() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.createNamedQuery("Student.deleteAll").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void dropStudentTables() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query q = entityManager.createNativeQuery("DROP TABLE student");
        q.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

