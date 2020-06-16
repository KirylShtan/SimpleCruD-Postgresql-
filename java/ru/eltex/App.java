package ru.eltex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.eltex.entity.Users;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(Users.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());

        //CRUD
        //Create
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Users("Igor","900"));


        transaction.commit();
        session.close();

        //Read
        Session sessionRead = sessionFactory.openSession();
        Transaction transactionRead = sessionRead.beginTransaction();
        Users user = sessionRead.find(Users.class,1);
        System.out.println(user.toString());
        transactionRead.commit();
        sessionRead.close();
        //Update
        Session sessionUpdate = sessionFactory.openSession();
        Transaction transactionUpdate = sessionUpdate.beginTransaction();
        user.setPhone("1232545245234");
        sessionUpdate.update(user);
        transactionUpdate.commit();
        sessionUpdate.close();
        //Delete
        Session sessionDelete = sessionFactory.openSession();
        Transaction transactionDelete = sessionDelete.beginTransaction();
        sessionDelete.delete(user);
        transactionDelete.commit();
        sessionDelete.close();

        Session sessionAdd =  sessionFactory.openSession();
        Transaction transactionAdd = sessionAdd.beginTransaction();
        Query query = sessionAdd.createSQLQuery("INSERT into Users (id,name,phone) VALUES ('4','Kiryl','31241')");
        query.executeUpdate();
        transactionAdd.commit();
        sessionAdd.close();
    }
}
