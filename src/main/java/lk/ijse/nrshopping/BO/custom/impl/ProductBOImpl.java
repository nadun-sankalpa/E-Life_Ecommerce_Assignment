package lk.ijse.nrshopping.BO.custom.impl;

import lk.ijse.nrshopping.BO.custom.ProductBO;
import lk.ijse.nrshopping.DAO.DAOFactory;
import lk.ijse.nrshopping.DAO.custom.ProductDAO;
import lk.ijse.nrshopping.Entity.Product;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }
}
