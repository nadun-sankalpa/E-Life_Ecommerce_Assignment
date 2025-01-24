package lk.ijse.nrshopping.DAO;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {
    boolean save (T entity);
    void update(T entity);
    void delete(ID id);
    T findById(ID id);
    List<T> getAll();
}
