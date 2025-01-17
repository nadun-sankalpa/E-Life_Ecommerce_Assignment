package lk.ijse.nrshopping.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        sessionFactory = new Configuration().buildSessionFactory();
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
