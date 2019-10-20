package entities;

import javax.persistence.*;

import java.util.HashSet;

import java.util.Set;

@Entity
public class College {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int id;

    private String collegeName;
    private int totNumStudents;
    private String address;
    private int phoneNum;

    @ManyToMany
    @JoinTable(
            name="college_student",
            joinColumns = @JoinColumn(name="college_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student> student = new HashSet<>();

    public College() {}

    public College(String collegeName, int totNumStudents, String address, int phoneNum) {
        this.collegeName = collegeName;
        this.totNumStudents = totNumStudents;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getTotNumStudents() {
        return totNumStudents;
    }

    public void setTotNumStudents(int totNumStudents) {
        this.totNumStudents = totNumStudents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public void addStudent(Student student) {
        student.add(student);
        student.getColleges().add(this);
    }

    public void removeStudents(Student student) {
        student.remove(student);
        student.getColleges().remove(this);
    }
}
