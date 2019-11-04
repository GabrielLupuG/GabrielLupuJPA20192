//Gabiel Lupu c15712195  DT354/ year 4
package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Module.getAll", query = "SELECT m FROM Module m")

})

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String moduleName;
    private String classNumber;
    private String moduleCode;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany(mappedBy = "modules", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    public Module() {
    }

    public Module(String moduleName, String classNumber, String moduleCode) {
        this.moduleName = moduleName;
        this.classNumber = classNumber;
        this.moduleCode = moduleCode;
    }

    public Module(String moduleName, String classNumber, String moduleCode, Set<Student> students) {
        this.moduleName = moduleName;
        this.classNumber = classNumber;
        this.moduleCode = moduleCode;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "\nModule{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", students=" + students +
                '}';
    }
}
