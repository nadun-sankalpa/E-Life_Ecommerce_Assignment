package lk.ijse.nrshopping.DAO;

import lk.ijse.nrshopping.DAO.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){return (daoFactory==null) ? daoFactory =new DAOFactory():daoFactory;}
    public enum DAOTypes{
        USER, CART,CATEGORY, PRODUCT, ORDER, ORDER_DETAIL
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case USER:
                return new UserDAOImpl();
            case CART:
                return new CartDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case CATEGORY:
                return new CategaryDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
