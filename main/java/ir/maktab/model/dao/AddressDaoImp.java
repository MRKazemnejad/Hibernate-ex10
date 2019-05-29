package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDaoImp;
import ir.maktab.model.Address;
import ir.maktab.model.Student;
import ir.maktab.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AddressDaoImp extends BaseDaoImp<Address> implements AddressDao {
    public AddressDaoImp(SessionFactory sessionFactory) {

        super(sessionFactory);
    }

    @Override
    protected String getEntityName() {
        return null;
    }

}
