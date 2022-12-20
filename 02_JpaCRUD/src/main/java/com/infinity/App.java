package com.infinity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infinity.entity.Student;
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(202, "Test", 40); //Transient State
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager entityManager = factory.createEntityManager();
   
        entityManager.getTransaction().begin();
        entityManager.persist(student); //Insert Query // Attached or Managed State
        entityManager.getTransaction().commit();
   
        
        Student result = entityManager.find(Student.class, student.getStudentId());//select //Attached or Managed state
        System.out.println(result.getStudentId()+ " , "+result.getStudentName()+" , "+result.getStudentScore());
       
        entityManager.getTransaction().begin();
        result.setStudentName("Saurav");
        result.setStudentScore(85);
        entityManager.merge(result); //Update Query //Attached or Manage State
        entityManager.getTransaction().commit();
        
        
        Student result2 = entityManager.find(Student.class, student.getStudentId());
        System.out.println(result2.getStudentId()+ " , "+result2.getStudentName()+" , "+result2.getStudentScore());
       
        entityManager.getTransaction().begin();
        entityManager.remove(result2); //Delete Query //Removed State
        entityManager.getTransaction().commit();
       
        
        Student result3 = entityManager.find(Student.class, student.getStudentId());
        System.out.println(result3);
     
    }
}
