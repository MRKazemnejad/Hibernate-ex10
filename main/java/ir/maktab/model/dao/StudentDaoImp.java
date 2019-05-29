package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDaoImp;
import ir.maktab.model.Student;
import ir.maktab.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp extends BaseDaoImp<Student> implements StudentDao {
    @Override
    protected String getEntityName() {
        return "Student";
    }

    public StudentDaoImp(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    @Override
    public Query searchByName(String name) {
        Session session = factory.openSession();
        Query query = session.createQuery("from " + getEntityName() + " as entity where entity.firstName like '%"+name+"%' or entity.lastName like '%"+name+"%'");

        return query;
    }

    @Override
    public List<Student> studentFindByCity(String city) {
        Session session=factory.openSession();
        Query query=session.createQuery("from "+getEntityName()+" as t where t.address.city like '%"+city+"%'");
        List<Student> list=query.list();
        session.close();
        return list;
    }
}
