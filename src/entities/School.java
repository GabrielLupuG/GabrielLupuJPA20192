package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    private String schoolName;
    private String address;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Module> moduleList = new ArrayList<>();

    public School() {
    }

    public School(String schoolName, String address, String phoneNumber, List<Module> moduleList) {
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.moduleList = moduleList;
    }

    public void addModule(Module module) {
        moduleList.add(module);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }
}
