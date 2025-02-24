package com.project.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class AppDelete {
 
    public static void main(String[] args) {
        System.out.println("Project started..");
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx =session.beginTransaction();
       
        Student s=session.get(Student.class, 102);
        session.delete(s);
        tx.commit();
        factory.close();
         
    }
 
}