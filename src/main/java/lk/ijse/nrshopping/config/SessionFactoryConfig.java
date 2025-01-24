package lk.ijse.nrshopping.config;

import lk.ijse.nrshopping.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        sessionFactory = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(Product.class).addAnnotatedClass(OrderDetail.class).addAnnotatedClass(Order.class).addAnnotatedClass(Category.class).addAnnotatedClass(Cart.class).buildSessionFactory();
    }


    public static SessionFactoryConfig getInstance(){
        if (factoryConfig==null){
            factoryConfig = new SessionFactoryConfig();
        }
        return factoryConfig;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
