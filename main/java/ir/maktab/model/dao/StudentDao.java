package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDao;
import ir.maktab.model.Student;
import org.hibernate.query.Query;

import java.util.List;

public interface StudentDao extends BaseDao<Student> {
    Query searchByName(String name);
    List<Student> studentFindByCity(String city);

}
