package Clases;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class Hibernate {
    public static void insertarHib(ArrayList<Result> listaResultados){
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();


        Session sesion = sf.openSession();
        sesion.beginTransaction();

        for(Result resultado : listaResultados) {
            sesion.persist(resultado);
        }

        sesion.getTransaction().commit();
        sesion.close();
        sf.close();
    }
}
