package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "StudentCard.findAll", query = "SELECT s FROM StudentCard s")
})
@Entity
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String courseName;
    private String studentNumber;

    public StudentCard() {
    }

    public StudentCard(String firstName, String lastName, String courseName, String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.studentNumber = studentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "\nStudentCard{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                '}';
    }
}