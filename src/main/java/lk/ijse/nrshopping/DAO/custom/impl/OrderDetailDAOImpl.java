package lk.ijse.nrshopping.DAO.custom.impl;

import lk.ijse.nrshopping.DAO.custom.OrderDetailDAO;
import lk.ijse.nrshopping.Entity.OrderDetail;
import lk.ijse.nrshopping.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public void update(OrderDetail entity) {

    }

    @Override
    public OrderDetail findById(String s) {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() {
        return null;
    }

    @Override
    public void save(OrderDetail orderDetail) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(orderDetail);
            transaction.commit();
        }
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Query<OrderDetail> query = session.createQuery("FROM OrderDetail WHERE order.id = :orderId", OrderDetail.class);
            query.setParameter("orderId", orderId);
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void delete(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            OrderDetail orderDetail = session.get(OrderDetail.class, id);
            if (orderDetail != null) {
                session.remove(orderDetail);
            }
            transaction.commit();
        }
    }
}
