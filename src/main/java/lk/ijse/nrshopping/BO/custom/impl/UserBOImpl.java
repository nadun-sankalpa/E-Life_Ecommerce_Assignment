package lk.ijse.nrshopping.BO.custom.impl;

import lk.ijse.nrshopping.BO.custom.UserBO;
import lk.ijse.nrshopping.DAO.DAOFactory;
import lk.ijse.nrshopping.DAO.custom.UserDAO;
import lk.ijse.nrshopping.Entity.User;

import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(User user) {
        return userDAO.save(user);
    }
    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public boolean updateStatus(String id, boolean status) {
        return userDAO.updateStatus(id,status);
    }
}
