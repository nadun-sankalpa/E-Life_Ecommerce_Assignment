package lk.ijse.nrshopping.BO.custom;

import lk.ijse.nrshopping.BO.SuperBO;
import lk.ijse.nrshopping.Entity.User;

public interface UserSaveBO extends SuperBO {
    boolean savUser(User user);
}
