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
    public boolean save(User user) {
        try(Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class,id);
            if (user != null){
                session.remove(user);
                return true;
            }
            transaction.commit();
            return false;
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
            Query<User> query = session.createQuery("from User where username = :username", User.class);
            query.setParameter("username",userName);
            return query.uniqueResult();
        }
    }

    @Override
    public boolean updateStatus(String id, boolean status) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();

            // Log the incoming userId and status
            System.out.println("Attempting to update user with ID: " + id + " to status: " + status);

            User user = session.get(User.class, id);
            if (user != null) {
                user.setActive(status);
                session.merge(user);
                transaction.commit();
                System.out.println("User status updated successfully.");
                return true;
            } else {
                System.out.println("User with ID " + id + " not found.");
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
