package operators.blocks;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySinglton {

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Создана org.hibernate.SessionFactory.\n");
        }
        return  sessionFactory;
    }

    public static void  closeSessionFactory(){
        if (sessionFactory!=null){
            sessionFactory.close();
            System.out.println("\norg.hibernate.SessionFactory закрыта.");
        }
    }

}
