package lk.ijse.nrshopping.BO.custom;

import lk.ijse.nrshopping.BO.SuperBO;
import lk.ijse.nrshopping.Entity.User;

import java.util.List;

public interface UserBO extends SuperBO {
    boolean saveUser(User user);
    User findByUserName(String userName);

    List<User> getAll();
    boolean updateStatus(String id, boolean status);
}
