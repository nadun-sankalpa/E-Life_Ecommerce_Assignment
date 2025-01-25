package lk.ijse.nrshopping.DAO;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {
    boolean save (T entity);
    boolean update(T entity);
    boolean delete(ID id);
    T findById(ID id);
    List<T> getAll();
}
