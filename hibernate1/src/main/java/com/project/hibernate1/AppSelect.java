package com.project.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class AppSelect {
 
    public static void main(String[] args) {
        System.out.println("Project started..");
 
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session= factory.openSession();
       
 
          //Read Data from Table Student
          Student s1=(Student)session.get(Student.class, 1022);
          System.out.println(s1);
          System.out.println("Fetching object using load:");
          Student s2=(Student)session.load(Student.class,1022);
          System.out.println(s2);
    }
 
}
