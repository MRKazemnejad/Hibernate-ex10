package ir.maktab.model.dao;

import ir.maktab.core.dao.BaseDao;
import ir.maktab.model.Teacher;

import java.io.Serializable;
import java.util.List;

public interface TeacherDao extends BaseDao<Teacher> {
    List<Teacher> youngOldTeacher();
    List<Teacher> minmaxSalary();
    void deleteByCode(Integer code);
    List<Teacher> teacherFindByPhoneCode(String code);
    List<Teacher> teacherFindByCity(String city);
    List<Teacher> teacherFindByPhoneandCity(String phone,String city);



}
