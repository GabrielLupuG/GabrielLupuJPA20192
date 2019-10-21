package entities;

import javax.persistence.*;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameModule;
    private int classNumber;
    private String codeModule;


    @ManyToOne
    private StudentId studentId;//1



    public Module() {
    }

    public Module(String nameModule, int classNumber, String codeModule, StudentId studentId) {
        this.nameModule = nameModule;
        this.classNumber = classNumber;
        this.codeModule = codeModule;
        this.studentId = studentId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }
}
