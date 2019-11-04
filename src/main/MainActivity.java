//Gabiel Lupu c15712195  DT354/ year 4

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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                StudentCardDAO studentCardDAO = new StudentCardDAO();
                StudentCard myStudentCard = new StudentCard("Lupu", "Gabriel", "BSC InfoSystem", "C11111");
                StudentCard myStudentCard1 = new StudentCard("Karl", "Mick", "Bs Business", "C22222");
                StudentCard myStudentCard2 = new StudentCard("Robert", "Redford", "BSc Accounting", "C33333");
                StudentCard myStudentCard3 = new StudentCard("Hana", "Montana", "BArch Architecture", "C44444");
                StudentCard myStudentCard4 = new StudentCard("Boby", "Marks", "BAeng English", "C23231");
                StudentCard myStudentCard5 = new StudentCard("Dany", "Dann", "BLit Literature", "C33322");

                studentCardDAO.persistStudent(myStudentCard);
                studentCardDAO.persistStudent(myStudentCard1);
                studentCardDAO.persistStudent(myStudentCard2);
                studentCardDAO.persistStudent(myStudentCard3);
                studentCardDAO.persistStudent(myStudentCard4);
                studentCardDAO.persistStudent(myStudentCard5);

                //update Student Card
                myStudentCard1.setFirstName("Lupu");
                myStudentCard1.setLastName("Oana");
                studentCardDAO.updateStudentCard(myStudentCard1);

                //delete Student Card
                studentCardDAO.deleteStudentCard(myStudentCard5); //

                System.out.println("\n" + studentCardDAO.getAllStudentCards());

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //creating Student table and attached to card
                StudentDAO studentDAO = new StudentDAO();
                Student myStudent = new Student("Watlings st", "gabriel@mail.com", "11111111", myStudentCard, modules);
                Student myStudent1 = new Student("Bonham st", "Oana@mail.com", "222222222", myStudentCard1, modules);
                Student myStudent2 = new Student("Island st", "Robert@mail.com", "3333333333", myStudentCard2, modules1);
                Student myStudent3 = new Student("Liffey st", "Hana@mail.com", "444444444", myStudentCard3, modules1);
                Student myStudent4 = new Student("Ellis st", "Moana@mail.com", "444444444", myStudentCard4, modules1);
                Student myStudent5 = new Student("Wood st", "mikes@mail.com", "555555555", null);

                studentDAO.persistStudent(myStudent);
                studentDAO.persistStudent(myStudent1);
                studentDAO.persistStudent(myStudent2);
                studentDAO.persistStudent(myStudent3);
                studentDAO.persistStudent(myStudent4);
                studentDAO.persistStudent(myStudent5);


                //update student
                myStudent1.setAddress("James");
                myStudent1.setEmail("james@mail.com");
                myStudent1.setPhoneNumber("012938");
                studentDAO.updateStudent(myStudent1);

                //delete student
                studentDAO.deleteStudent(myStudent5);

                System.out.println("\n" + studentDAO.getAllStudents());


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                System.out.println("\n" + moduleDAO.getAllModules());

                List<Module> modules2 = new ArrayList<>();
                modules2.add(module);
                modules2.add(module1);

                SchoolDAO schoolDAO = new SchoolDAO();
                School school = new School("DIT", "Thomas st", " 123456", modules2);
                School school1 = new School("UTC", "O'Conell st", "345678", null);
                School school2 = new School("DCU", "Parnell st", "567890", null);
                School school3 = new School("TCA", "Kevin st", "789012", null);

                schoolDAO.persistSchool(school);
                schoolDAO.persistSchool(school1);
                schoolDAO.persistSchool(school2);
                schoolDAO.persistSchool(school3);

                //update school
                School helperSchool = schoolDAO.getById("School.getById", "id", 2);
                helperSchool.setSchoolName("TUDublin");
                helperSchool.setAddress("Aungier Street");
                helperSchool.setPhoneNumber("0812312312");
                schoolDAO.updateStudent(helperSchool);


                //delete School
                schoolDAO.deleteSchool(school3);
                System.out.println("\n" + schoolDAO.getAllSchools());


                //deleting the student table
                studentDAO.deleteAllStudents();
                //drop student table
                studentDAO.dropStudentTables();

                // moduleDAO.deleteAllModule();
                //drop Moduel table
                moduleDAO.dropModuleTables();
                //remove
                moduleDAO.mergeModule();
                moduleDAO.removeModule();
        }

        public static void main(String[] args) {
                new MainActivity();
        }
}
