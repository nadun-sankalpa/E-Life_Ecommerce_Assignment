package lk.ijse.nrshopping.DAO.custom;

import lk.ijse.nrshopping.DAO.CrudDAO;
import lk.ijse.nrshopping.Entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    public boolean save(User user);
    public boolean update(User user);

    public boolean delete(String id);
    public User findById(String id);

    public List<User> getAll();

    User findByUserName(String userName);

    boolean updateStatus(String id,boolean status);
}
