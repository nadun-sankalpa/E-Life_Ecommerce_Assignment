package lk.ijse.nrshopping.BO.custom;

import lk.ijse.nrshopping.BO.SuperBO;
import lk.ijse.nrshopping.Entity.Product;

public interface ProductBO extends SuperBO {
    boolean save(Product product);
}
