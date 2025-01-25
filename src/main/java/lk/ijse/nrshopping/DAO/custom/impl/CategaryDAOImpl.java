package lk.ijse.nrshopping.DAO.custom.impl;

import lk.ijse.nrshopping.DAO.custom.CategoryDAO;
import lk.ijse.nrshopping.Entity.Category;
import lk.ijse.nrshopping.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategaryDAOImpl implements CategoryDAO {
    @Override
    public boolean save(Category category) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category findById(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){

            return session.get(Category.class,id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Category> getAll() {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            List<Category> categoryList = session.createSelectionQuery("from Category ", Category.class).list();
            if (categoryList == null || categoryList.isEmpty()) {
                System.out.println("No categories found in the database.");
            } else {
                System.out.println("Fetched categories: " + categoryList.size());
            }
            transaction.commit();
            return categoryList;
        } catch (Exception e) {
            System.err.println("Error retrieving categories: " + e.getMessage());
            // Consider re-throwing the exception or returning a specific error code
            // to indicate the failure to the calling code.
            throw e; // Or return null or a specific error code
        }
    }




    @Override
    public boolean update(Category category) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(category);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.remove(category); // Remove the category
                transaction.commit();    // Commit the transaction
                return true;
            }
            transaction.rollback();      // Rollback if the category doesn't exist
            return false;
        } catch (Exception e) {
            e.printStackTrace();         // Log the exception
            return false;
        }
    }




    @Override
    public Category findByName(String name) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()){
            Query<Category> query = session.createQuery("from Category where name = ?", Category.class);
            query.setParameter(1,name);
            return query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
