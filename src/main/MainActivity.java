package main;


import dao.CollegeDAO;
import dao.ModuleDAO;
import dao.StudentDAO;
import dao.StudentIdDAO;
import entities.College;
import entities.Module;
import entities.Student;
import entities.StudentId;

public class MainActivity {

    public MainActivity(){

        StudentIdDAO studentIdDAO = new StudentIdDAO();
        StudentId ident = new StudentId("Lupu", "Gabriel", "BSC InfoSystem", "C11111");
        StudentId ident2 = new StudentId("Oana", "Lupu", "Bs Business", "C22222");
        studentIdDAO.persistStudentId(ident);
        studentIdDAO.persistStudentId(ident2);


        ModuleDAO moduleDAO = new ModuleDAO();
        Module module = new Module("Distributed System", 222, "1A",null);
        Module mod1 = new Module("Business ", 307, "1B",null);
        //module.addStudentId(studentIdDAO);
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
        College college = new College("DIT", 1800, "bolton St", 5555555);
        College college1 = new College("DCU", 2600, "kevin ST", 666666);

        college.addStudent(student);
        college.addStudent(student1);
        collegeDAO.persistCollege(college);
        collegeDAO.persistCollege(college1);

    }


    public static void main(String[] args) {
        new MainActivity();
    }
}
