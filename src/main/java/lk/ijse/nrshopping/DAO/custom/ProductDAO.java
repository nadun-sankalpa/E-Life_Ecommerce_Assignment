package lk.ijse.nrshopping.DAO.custom;

import lk.ijse.nrshopping.DAO.CrudDAO;
import lk.ijse.nrshopping.Entity.Product;

import java.util.List;

public interface ProductDAO extends CrudDAO<Product,String> {
    boolean save(Product product);

    Product findById(String id);

    List<Product> getAll();

    boolean update(Product product);

    boolean delete(String id);

    List<Product> findByName(String name);

    List<Product> findByCategory(String categoryId);
}
