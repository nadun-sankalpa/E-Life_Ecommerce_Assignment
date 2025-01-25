package lk.ijse.nrshopping.BO.custom.impl;

import lk.ijse.nrshopping.BO.custom.UserBO;
import lk.ijse.nrshopping.DAO.DAOFactory;
import lk.ijse.nrshopping.DAO.custom.UserDAO;
import lk.ijse.nrshopping.Entity.User;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean savUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }
}
