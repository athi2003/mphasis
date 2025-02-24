package com.project.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppInsert {
    public static void main(String[] args){
        System.out.println("Project started..");
 
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx =session.beginTransaction();
       
          //creating student
         
          Student st=new Student();
          st.setId(102);
          st.setName("Ashok");
          st.setCity("Delhi");
          System.out.println(st);
               
          session.save(st);
          tx.commit();
         
          factory.close();
          System.out.println("Done..");
       
       
       
       
       
       
   
 
    }
} 