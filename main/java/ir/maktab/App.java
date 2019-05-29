package ir.maktab;

import ir.maktab.model.Address;
import ir.maktab.model.Student;
import ir.maktab.model.Teacher;
import ir.maktab.model.dao.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TeacherDao teacherDao = new TeacherDopImp(factory);
        StudentDao studentDao = new StudentDaoImp(factory);
        AddressDao addressDao = new AddressDaoImp(factory);
//        Address teacherAdd1 = new Address("Tehran", "Tehran", "09121213344", "1234", "Iran,Tehran");
//        Address teacherAdd2 = new Address("Shiraz", "Shiraz", "09171453344", "1980", "Iran,Shiraz");
//        Address teacherAdd3 = new Address("Tehran", "Tehran", "09123337744", "1999", "Iran,Tehran");
//        Address teacherAdd4 = new Address("Esfahan", "Esfahan", "09131213344", "1654", "Iran,Esfahan");


        //****************************************************************
        //add some teachers
//        Teacher teacher = new Teacher("Ali", "Ahmadi", 123, LocalDate.of(1997, 05, 22), 1200);
//        Teacher teacher1 = new Teacher("Hasan", "Hamidi", 128, LocalDate.of(1987, 05, 01), 1500);
//        Teacher teacher2 = new Teacher("Reza", "najafi", 223, LocalDate.of(1991, 05, 11), 2200);
//        Teacher teacher3 = new Teacher("Yasr", "hoseini", 423, LocalDate.of(1985, 05, 02), 3200);
//        teacher.setAddress(teacherAdd1);
//        teacherDao.create(teacher);
//        teacher1.setAddress(teacherAdd2);
//        teacherDao.create(teacher1);
//        teacher2.setAddress(teacherAdd3);
//        teacherDao.create(teacher2);
//        teacher3.setAddress(teacherAdd4);
//        teacherDao.create(teacher3);

//        //**********************************************************************
//        //finding youngest and oldest teacher
//        System.out.println("Youngest and oldest teachers");
//        List<Teacher> list = new ArrayList<>();
//        list = teacherDao.youngOldTeacher();
//        System.out.println(list);
//        //*********************************************************************
//        //finding min and max salary
//        System.out.println("Max and min salary");
//        List<Teacher> list1 = new ArrayList<>();
//        list1 = teacherDao.minmaxSalary();
//        System.out.println(list1);
//        //*********************************************************************
//        // Removing teacher by code
//        System.out.println("Deleting teacher by code");
//        teacherDao.deleteByCode(123);
//        //********************************************************************
//
//        //********************************************************************
//        //adding some students
//        Student student = new Student("Ali reza", "rezaei");
//        Student student1 = new Student("Mohammad reza", "moradi");
//        Student student2 = new Student("Arsalan", "Mohammad");
//        Student student3=new Student("Arash","Shykhi");
//        Address studentAdd1 = new Address("Esfahan", "Esfahan", "09139904567", "1654", "Iran,Esfahan");
//        Address studentAdd2 = new Address("Chalus", "Mazandaran", "09111218090", "1456", "Iran,Mazandaran");
//        Address studentAdd3 = new Address("Rasht", "Gilan", "09111213462", "1632", "Iran,Gilan");
//        Address studentAdd4 = new Address("Tehran", "Tehran", "09121212267", "13453", "Iran,Tehran");
//        student.setAddress(studentAdd1);
//        studentDao.create(student);
//        student1.setAddress(studentAdd2);
//        studentDao.create(student1);
//        student2.setAddress(studentAdd3);
//        studentDao.create(student2);
//        student3.setAddress(studentAdd4);
//        studentDao.create(student3);

//        //********************************************************************
//        //finding similar names
//        System.out.println("Finding similar names");
//        Query q = studentDao.searchByName("Mohammad");
//        System.out.println(q.list());
//
//        //********************************************************************
//        //Criteria
//        Session session = factory.openSession();
//        Criteria cr = session.createCriteria(Student.class);
////        List list=cr.list();
////        System.out.println(list);
//        //*********************************************************************
//        //get similar names with criteria method
//        cr.add(Restrictions.like("firstName", "%Mohammad%"));
//        List list4 = cr.list();
//        System.out.println(list4);
        //************************************************************************
        //names of tescher who live in tehran
        List<Teacher> list = new ArrayList<>();
        list=teacherDao.teacherFindByCity("Teharn");
        System.out.println("Teachers names:");
        for (Teacher t : list) {
            System.out.println(t.toString());
        }

        //*************************************************************************
        //Names of teachers who their phones start with 0912
        List<Teacher> list1 = new ArrayList<>();
        list1 = teacherDao.teacherFindByPhoneCode("0912");
        System.out.println("Teachers names:");
        for (Teacher t : list1) {
            System.out.println(t.toString());
        }
        //************************************************************************
        //Names of teachers who live in tehran and their phone start with 0912
        List<Teacher> list2 = new ArrayList<>();
        list2 = teacherDao.teacherFindByPhoneandCity("0912","Tehran");
        System.out.println("Teachers names:");
        for (Teacher t : list2) {
            System.out.println(t.toString());
        }

        //**************************************************************************
        //Names of students who live in tehran
        List<Student> list3 = new ArrayList<>();
        list3 = studentDao.studentFindByCity("Tehran");
        System.out.println("Students names:");
        for (Student t : list3) {
            System.out.println(t.toString());
        }
        //*************************************************************************
        factory.close();
    }
}
