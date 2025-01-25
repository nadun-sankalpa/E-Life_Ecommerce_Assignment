package lk.ijse.nrshopping.BO.custom.impl;

import lk.ijse.nrshopping.BO.custom.CategoryBO;
import lk.ijse.nrshopping.DAO.DAOFactory;
import lk.ijse.nrshopping.DAO.custom.CategoryDAO;
import lk.ijse.nrshopping.Entity.Category;

import java.util.List;

public class CategoryBOImpl implements CategoryBO {

    // Create a CategoryDAO instance
    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CATEGORY);

    @Override
    public boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }
    @Override
    public Category getById(String id) {
        return categoryDAO.findById(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(String id) {
        return categoryDAO.delete(id);
    }
}
