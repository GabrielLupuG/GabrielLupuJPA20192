//Gabiel Lupu c15712195  DT354/ year 4
package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.deleteAll", query = "delete from Student s "),
})

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.REMOVE)
    private StudentCard studentCard;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_module",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> modules = new HashSet<>();

    public Student() {
    }

    public Student(String address, String email, String phoneNumber, StudentCard studentCard) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.studentCard = studentCard;
    }

    public Student(String address, String email, String phoneNumber, StudentCard studentCard, Set<Module> modules) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.studentCard = studentCard;
        this.modules = modules;
    }

    public void addModule(Module module) {
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

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", " + studentCard +
//                ", modules=" + modules +
                '}';
    }
}


