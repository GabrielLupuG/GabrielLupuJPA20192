package main;


import dao.CollegeDAO;

import dao.IdentificationDAO;
import dao.ModuleDAO;

import dao.StudentDAO;
import entities.College;
import entities.Identification;
import entities.Module;
import entities.Student;

import java.util.Date;

public class MainActivity {

    public MainActivity(){

        IdentificationDAO identificationDAO = new IdentificationDAO();
        Identification ident = new Identification("Lupu", "Gabriel", "BSC InfoSystem", "C11111");
        Identification ident2 = new Identification("Oana", "Lupu", "Bs Business", "C22222");
        identificationDAO.persistIdentification(ident);
        identificationDAO.persistIdentification(ident2);

        Date date = new Date();
        ModuleDAO moduleDAO = new ModuleDAO();
        Module module = new Module("Distributed System", 222, "1A",null);
        Module mod1 = new Module("Business ", 307, "1B",null);
        moduleDAO.persistModule(module);
        moduleDAO.persistModule(mod1);


        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student("Pacii", "gabriel@mail.com", "11111111", ident);
        Student student1 = new Student("Oituz", "Oana@mail.com", "222222222", ident2);
        student.addModule(module);
        student.addModule(mod1);
        studentDAO.persistStudent(student);
        studentDAO.persistStudent(student1);


        CollegeDAO collegeDAO = new CollegeDAO();
        College college = new College("DIT", 180, "bolton St", 56666666);
        College college1 = new College("DCU", 2600, "kevin ST", 666666);

        college.addStudent(student);
        college.addStudent(student1);
        collegeDAO.persistCollege(college);
        collegeDAO.persistCollege(college1);

    }


    public static void main(String args[]){
        new MainActivity();
    }
}
