package ir.maktab.core.dao;

import java.io.Serializable;

public interface BaseDao<E extends Serializable> {
    void create(E e);

    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);
}
