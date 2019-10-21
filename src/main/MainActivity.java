package main;

import dao.StudentCardDAO;
import dao.StudentDAO;
import entities.Student;
import entities.StudentCard;

public class MainActivity {

    public MainActivity(){


        //creaza lista de studentId cu autoIncrement number
        //adauga informatiile de mai jos in baza de date. informatile din studentIdDao care face conexiunea cu baza de date
        StudentCardDAO studentCardDAO = new StudentCardDAO();
        StudentCard myStudentCard = new StudentCard("Lupu", "Gabriel", "BSC InfoSystem", "C11111");
        StudentCard myStudentCard1 = new StudentCard("Oana", "Lupu", "Bs Business", "C22222");
        StudentCard myStudentCard2 = new StudentCard("Alex", "Lupu", "Bs Business", "C333333");
        StudentCard myStudentCard3 = new StudentCard("Sofia", "Lupu", "Bs Business", "C444444");

        System.out.println("\n" + studentCardDAO.getAllStudentCards());
        studentCardDAO.persistStudentId(myStudentCard);
        studentCardDAO.persistStudentId(myStudentCard1);
        studentCardDAO.persistStudentId(myStudentCard2);
        studentCardDAO.persistStudentId(myStudentCard3);

        myStudentCard1.setFirstName("Lupu");
        myStudentCard1.setLastName("Oana");
        System.out.println("\n" + studentCardDAO.getAllStudentCards());

        studentCardDAO.updateStudentCard(myStudentCard1);

        studentCardDAO.deleteStudentCard(myStudentCard2);

        System.out.println("\n" + studentCardDAO.getAllStudentCards());


        //creaza tabelul Student si ii ataseaza un card
        StudentDAO studentDAO = new StudentDAO();
        Student myStudent = new Student("Pacii", "gabriel@mail.com", "11111111", myStudentCard);
        Student myStudent1 = new Student("Oituz", "Oana@mail.com", "222222222", myStudentCard1);
        Student myStudent2 = new Student("Bogdanesti", "Alex@mail.com", "3333333333", myStudentCard3);

        studentDAO.persistStudent(myStudent);
        studentDAO.persistStudent(myStudent1);
        studentDAO.persistStudent(myStudent2);

        System.out.println(studentDAO.);

        //trimite informatia in student dao
//        studentDAO.persistStudent(student);
//        studentDAO.persistStudent(student1);


//        ModuleDAO moduleDAO = new ModuleDAO();
//        Module module = new Module("Distributed System", 222, "1A", ident);
//        Module mod1 = new Module("Business ", 307, "1B", ident2);
//        //module.addStudentId(studentIdDAO);
//        moduleDAO.persistModule(module);
//        moduleDAO.persistModule(mod1);


        //adauga
//        student.addModule(module);
//        student.addModule(mod1);


//        CollegeDAO collegeDAO = new CollegeDAO();
//        School school = new School("DIT", 1800, "bolton St", 5555555);
//        School school1 = new School("DCU", 2600, "kevin ST", 666666);
//
//        school.addStudent(student);
//        school.addStudent(student1);
//        collegeDAO.persistCollege(school);
//        collegeDAO.persistCollege(school1);

    }


    public static void main(String[] args) {
        new MainActivity();
    }
}
