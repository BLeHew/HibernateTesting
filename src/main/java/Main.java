import hib.Project;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    static SessionFactory sessionFactoryObj;

    static Session sessionObj;


    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        try {
            long msStart = System.currentTimeMillis();
            sessionFactoryObj = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("Took: " + (System.currentTimeMillis() - msStart) + " to create session factory");
            sessionObj = sessionFactoryObj.openSession();
            //System.out.print(sessionFactoryObj.isOpen());

            //sessionObj = sessionFactoryObj.openSession();
            //sessionObj.beginTransaction();


            Project project = sessionObj.get(Project.class,3);


            msStart = System.currentTimeMillis();


            List<Project> projects = sessionObj.createQuery("from Project").list();

            System.out.println("Took: " + (System.currentTimeMillis() - msStart) + " to retreive objects list");

            //sessionObj = ((SessionFactory) entityManagerFactory).openSession();
            //sessionObj.beginTransaction();

            sessionObj.close();

        }catch (Exception e){
            e.printStackTrace();
            if(null != sessionObj.getTransaction()){
                System.out.println("Failled entry, rolling back");
                sessionObj.getTransaction().rollback();
            }
        }finally {
            if(sessionObj != null){
                sessionObj.close();
            }
        }
    }
}