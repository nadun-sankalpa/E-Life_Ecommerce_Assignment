package lk.ijse.nrshopping.BO;

import lk.ijse.nrshopping.BO.custom.impl.UserSaveBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBoFactory(){return (boFactory==null)?boFactory=new BOFactory():boFactory;}

    public enum BOTypes{
        SAVE_USER
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case SAVE_USER:
                return new UserSaveBOImpl();
            default:
                return null;
        }
    }
}
