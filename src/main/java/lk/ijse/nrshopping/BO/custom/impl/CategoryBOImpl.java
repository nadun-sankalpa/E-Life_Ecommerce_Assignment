package lk.ijse.nrshopping.BO.custom.impl;

import lk.ijse.nrshopping.BO.custom.CategoryBO;
import lk.ijse.nrshopping.DAO.DAOFactory;
import lk.ijse.nrshopping.DAO.custom.CategoryDAO;
import lk.ijse.nrshopping.Entity.Category;

import java.util.List;

public class CategoryBOImpl implements CategoryBO {
    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CATEGORY);
    @Override
    public boolean save(Category category) {
        if (categoryDAO.save(category)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }
}
