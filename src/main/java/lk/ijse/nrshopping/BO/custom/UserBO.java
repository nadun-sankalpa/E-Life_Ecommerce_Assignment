package lk.ijse.nrshopping.BO.custom;

import lk.ijse.nrshopping.BO.SuperBO;
import lk.ijse.nrshopping.Entity.User;

public interface UserBO extends SuperBO {
    boolean savUser(User user);

    User findByUserName(String userName);
}
