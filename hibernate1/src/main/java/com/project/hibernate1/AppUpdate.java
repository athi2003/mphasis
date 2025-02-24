package com.project.hibernate1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppUpdate {

   public static void main(String[] args) {
       System.out.println("Project started..");

       Configuration cfg = new Configuration();
       cfg.configure();
       SessionFactory factory = cfg.buildSessionFactory();
       Session session= factory.openSession();
       Transaction tx =session.beginTransaction();
       
       Student s1=(Student)session.get(Student.class, 1022);
       s1.setName("Bijoy");
       session.save(s1);
       tx.commit();
       factory.close();
       System.out.println("Done..");
   }

}
