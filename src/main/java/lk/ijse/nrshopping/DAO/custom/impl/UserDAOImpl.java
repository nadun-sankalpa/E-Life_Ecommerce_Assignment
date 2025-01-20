package lk.ijse.nrshopping.DAO.custom.impl;

import lk.ijse.nrshopping.DAO.custom.UserDAO;
import lk.ijse.nrshopping.Entity.User;
import lk.ijse.nrshopping.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user) {
        try(Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();

        }
    }

    @Override
    public void update(User user) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();

        }
    }

    @Override
    public void delete(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class,id);
            if (user != null){
                session.remove(user);
            }
            transaction.commit();
        }
    }

    @Override
    public User findById(String id) {
        try(Session session = SessionFactoryConfig.getInstance().getSession()) {

            return session.get(User.class, id);

        }

    }

    @Override
    public List<User> getAll() {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Query<User> query = session.createQuery("FROM User ",User.class);
            return query.list();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByUserName(String userName) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Query<User> query = session.createQuery("from User where username = ?", User.class);
            query.setParameter(1,userName);
            return query.uniqueResult();
        }
    }
}
