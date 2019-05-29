package ir.maktab.model.dao;


import ir.maktab.core.dao.BaseDaoImp;
import ir.maktab.model.Student;
import ir.maktab.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TeacherDopImp extends BaseDaoImp<Teacher> implements TeacherDao {

    public TeacherDopImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected String getEntityName() {
        return "Teacher";
    }

    @Override
    public List<Teacher> youngOldTeacher() {
        List<Teacher> list = new ArrayList<>();
        Session session = factory.openSession();

        session.beginTransaction();

        Object singleResult = session.createQuery("from Teacher t order by t.birthday ").setMaxResults(1).getSingleResult();
        list.add((Teacher) singleResult);
        Object singleResult1 = session.createQuery("from Teacher t order by t.birthday desc ").setMaxResults(1).getSingleResult();
        list.add((Teacher) singleResult1);
        Teacher e = (Teacher) singleResult;
        session.getTransaction().commit();

        session.close();

        return list;
    }

    @Override
    public List<Teacher> minmaxSalary() {
        List<Teacher> list = new ArrayList<>();
        Session session = factory.openSession();

        session.beginTransaction();

        Object singleResult = session.createQuery("from Teacher t order by t.salary ").setMaxResults(1).getSingleResult();
        list.add((Teacher) singleResult);
        Object singleResult1 = session.createQuery("from Teacher t order by t.salary desc ").setMaxResults(1).getSingleResult();
        list.add((Teacher) singleResult1);
        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public void deleteByCode(Integer code) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete from " + getEntityName() + " as t where t.teacherCode="+code).executeUpdate();

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<Teacher> teacherFindByPhoneCode(String code) {
        Session session=factory.openSession();
        Query query=session.createQuery("from "+getEntityName()+" as t where t.address.number like '"+code+"%'");
        List<Teacher> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<Teacher> teacherFindByCity(String city) {
        Session session=factory.openSession();
        Query query=session.createQuery("from "+getEntityName()+" as t where t.address.number like '%"+city+"%'");
        List<Teacher> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<Teacher> teacherFindByPhoneandCity(String phone, String city) {
        Session session=factory.openSession();
        Query query=session.createQuery("from "+getEntityName()+" as t where t.address.number like '"+phone+"%' and t.address.city like '%"+city+"%'");
        List<Teacher> list=query.list();
        session.close();
        return list;
    }
}
