package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private String email;
    private String phoneNumber;

    @OneToOne
    private StudentId identification;

    @OneToMany
    private List<Module> modules = new ArrayList<>();

    @ManyToMany(mappedBy = "student")
    private Set<College> colleges = new HashSet<>();

    public Student() {}

    public Student(String address, String email, String phoneNumber, StudentId identification) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identification = identification;
    }

    public Student(String address, String email, String phoneNumber, StudentId identification, List<Module> modules) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identification = identification;
        this.modules = modules;
    }

    public void addModule(Module module){
        modules.add(module);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentId getIdentification() {
        return identification;
    }

    public void setPassport(StudentId identification) {
        this.identification = identification;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Set<College> getColleges() {
        return colleges;
    }

    public void setColleges(Set<College> colleges) {
        this.colleges = colleges;
    }

    public void addCollege(College college){
        colleges.add(college);
        college.getStudent().add(this);
    }

    public void add(Student student) {
    }

    public void remove(Student student) {
    }
}
