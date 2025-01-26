package lk.ijse.nrshopping.BO;

import lk.ijse.nrshopping.BO.custom.impl.CategoryBOImpl;
import lk.ijse.nrshopping.BO.custom.impl.ProductBOImpl;
import lk.ijse.nrshopping.BO.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBoFactory(){return (boFactory==null)?boFactory=new BOFactory():boFactory;}

    public enum BOTypes{
        CATEGORY, USER, PRODUCT
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case CATEGORY:
                return new CategoryBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            default:
                return null;
        }
    }
}
