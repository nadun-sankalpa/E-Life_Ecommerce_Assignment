package lk.ijse.nrshopping.DAO.custom;

import lk.ijse.nrshopping.DAO.CrudDAO;
import lk.ijse.nrshopping.Entity.Cart;

public interface CartDAO extends CrudDAO<Cart,String> {
    boolean save(Cart cart);

    Cart findById(String id);

    void update(Cart cart);

    void delete(String id);
}
