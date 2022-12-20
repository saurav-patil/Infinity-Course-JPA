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
        Student student1 = new Student(101, "Sachin T", 90);
        Student student2 = new Student(102, "M Dhoni",84);
        
        Department department = new Department(10, "IT");
      
        student1.setDepartment(department);
        student2.setDepartment(department);
        
        department.addStudent(student1);
        department.addStudent(student2);
        
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager entityManager = factory.createEntityManager();
   
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
  
        entityManager.close();

        System.out.println("Record Inserted .. ");
    }
}
