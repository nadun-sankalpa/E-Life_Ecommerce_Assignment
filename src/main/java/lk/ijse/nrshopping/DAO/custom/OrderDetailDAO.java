package lk.ijse.nrshopping.DAO.custom;

import lk.ijse.nrshopping.DAO.CrudDAO;
import lk.ijse.nrshopping.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetail, String> {
    boolean save(OrderDetail orderDetail);

    List<OrderDetail> findByOrderId(String orderId);

    void delete(String id);
}
