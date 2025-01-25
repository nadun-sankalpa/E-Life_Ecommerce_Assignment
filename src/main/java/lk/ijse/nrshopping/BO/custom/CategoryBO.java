package lk.ijse.nrshopping.BO.custom;

import lk.ijse.nrshopping.BO.SuperBO;
import lk.ijse.nrshopping.Entity.Category;

import java.util.List;

public interface CategoryBO extends SuperBO {
    boolean save(Category category);

    List<Category> getAll();
    Category getById(String id);
    boolean update(Category category);

    boolean delete(String id);


}
