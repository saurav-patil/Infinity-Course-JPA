package com.infinity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infinity.entity.Student;
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(201, "Virat Kohli", 60);
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager entityManager = factory.createEntityManager();
   
        entityManager.getTransaction().begin();
        entityManager.persist(student); //Insert Query
        entityManager.getTransaction().commit();
   
        System.out.println("Record Inserted .. ");
    }
}
