package ir.maktab.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImp<E extends Serializable> implements BaseDao<E> {
    protected SessionFactory factory;

    public BaseDaoImp(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public E update(E e) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        return e;
    }

    @Override
    public E read(Serializable id) {
        Session session = factory.openSession();
        E e = (E) session.get(getEntityName(), id);
        session.close();
        return e;
    }

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createQuery("delete from " + getEntityName() + "as entity where entity.id=" + id);
        session.getTransaction().commit();
        session.close();
    }
}
