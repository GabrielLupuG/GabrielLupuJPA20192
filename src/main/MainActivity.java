package main;

import dao.ModuleDAO;
import dao.SchoolDAO;
import dao.StudentCardDAO;
import dao.StudentDAO;
import entities.Module;
import entities.School;
import entities.Student;
import entities.StudentCard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity {

        public MainActivity() {

                ModuleDAO moduleDAO = new ModuleDAO();
                Module module = new Module("Distributed System", "2222", "1A");
                Module module1 = new Module("Business ", "307", "1B");
                moduleDAO.persistModule(module);
                moduleDAO.persistModule(module1);

                Set<Module> modules = new HashSet<>();
                modules.add(module);

                Set<Module> modules1 = new HashSet<>();
                modules1.add(module1);

                //creaza lista de studentId cu autoIncrement number
                //adauga informatiile de mai jos in baza de date. informatile din studentIdDao care face conexiunea cu baza de date
                StudentCardDAO studentCardDAO = new StudentCardDAO();

                StudentCard myStudentCard = new StudentCard("Lupu", "Gabriel", "BSC InfoSystem", "C11111");
                StudentCard myStudentCard1 = new StudentCard("Oana", "Lupu", "Bs Business", "C22222");
                StudentCard myStudentCard2 = new StudentCard("Robert", "Redford", "BSc Accounting", "C333333");
                StudentCard myStudentCard3 = new StudentCard("Hana", "Montana", "BArch Architecture", "C444444");
                StudentCard myStudentCard4 = new StudentCard("Bahaa", "Suleimany", "BAeng English", "C2323123");
                StudentCard myStudentCard5 = new StudentCard("asdadsa", "adsadsada", "asdadasda", "asdadasdasd");

                studentCardDAO.persistStudent(myStudentCard);
                studentCardDAO.persistStudent(myStudentCard1);
                studentCardDAO.persistStudent(myStudentCard2);
                studentCardDAO.persistStudent(myStudentCard3);
                studentCardDAO.persistStudent(myStudentCard4);
                studentCardDAO.persistStudent(myStudentCard5);

                myStudentCard1.setFirstName("Lupu");
                myStudentCard1.setLastName("Oana");
                studentCardDAO.updateStudentCard(myStudentCard1);

                studentCardDAO.deleteStudentCard(myStudentCard5); //

                System.out.println("\n" + studentCardDAO.getAllStudentCards());

                /////////////////////////////////////////////////////////////////////////////////////////////

                //creaza tabelul Student si ii ataseaza un card
                StudentDAO studentDAO = new StudentDAO();
                Student myStudent = new Student("Pacii", "gabriel@mail.com", "11111111", myStudentCard, modules);
                Student myStudent1 = new Student("Oituz", "Oana@mail.com", "222222222", myStudentCard1, modules);
                Student myStudent2 = new Student("Bogdanesti", "Robert@mail.com", "3333333333", myStudentCard2, modules1);
                Student myStudent3 = new Student("Republicii", "Hana@mail.com", "444444444", myStudentCard3, modules1);
                Student myStudent4 = new Student("Republicii", "Hana@mail.com", "444444444", myStudentCard4, modules1);
                Student myStudent5 = new Student("Ojtoz", "mikes@mail.com", "555555555", null);

                studentDAO.persistStudent(myStudent);
                studentDAO.persistStudent(myStudent1);
                studentDAO.persistStudent(myStudent2);
                studentDAO.persistStudent(myStudent3);
                studentDAO.persistStudent(myStudent4);
                studentDAO.persistStudent(myStudent5);

                //update one of your students
                //Student myStudentHelper = studentDAO.getOne
                //studentDAO.updateStudent();

                //sterg al 2 student
                studentDAO.deleteStudent(myStudent5);

                System.out.println("\n" + studentDAO.getAllStudents());


//////////////////////////////////////////////////////////////////////////////////////////////

                System.out.println("\n" + moduleDAO.getAllModules());

                List<Module> modules2 = new ArrayList<>();
                modules2.add(module);
                modules2.add(module1);

                SchoolDAO schoolDAO = new SchoolDAO();
                School school = new School("DIT", "Thomas st", " 123456", modules2);
                School school1 = new School("DCU", "O'Conell st", "k45678", null);
                School school2 = new School("DCU", "O'Conell st", "k45678", null);
                School school3 = new School("DCU", "O'Conell st", "k45678", null);

                schoolDAO.persistSchool(school);
                schoolDAO.persistSchool(school1);
                schoolDAO.persistSchool(school2);
                schoolDAO.persistSchool(school3);

                School helperSchool = schoolDAO.getById("School.getById", "id", 2);
                helperSchool.setSchoolName("TUDublin");
                helperSchool.setAddress("Aungier Street");
                helperSchool.setPhoneNumber("0812312312");
                schoolDAO.updateStudent(helperSchool);


                System.out.println("\n" + schoolDAO.getAllSchools());

                studentDAO.deleteAllStudents();
                studentDAO.dropStudentTables();

        }

        public static void main(String[] args) {
                new MainActivity();
        }
}
