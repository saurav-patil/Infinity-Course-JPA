package com.infinity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infinity.entity.Department;
import com.infinity.entity.Student;
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(280, "Pujara", 90);
        Department department = new Department(10, "IT");
        student.setDepartment(department); //Setup dependency //now this objects are related
        
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager entityManager = factory.createEntityManager();
   
        entityManager.getTransaction().begin();
        //entityManager.persist(department);
        entityManager.persist(student); //Insert Query
        entityManager.getTransaction().commit();
   
        System.out.println("Record Inserted .. ");
    }
}
