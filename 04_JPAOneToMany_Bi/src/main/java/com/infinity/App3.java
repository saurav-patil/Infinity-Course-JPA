package com.infinity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.infinity.entity.Student;

public class App3 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();

		
		int studentId = 102;
		
		//String jpql = "Select s From Student s";
//		String jpql = "Select s From Student s Where studentId = 101";
		String jpql = "Select s From Student s Where s.studentId = :stuId";
		
//		Query query = entityManager.createQuery(jpql);
//		List<Student> list = query.getResultList(); //query interface is not type safe

		TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
		query.setParameter("stuId", studentId);
		List<Student> list = query.getResultList();
		
		list.stream().forEach(s -> System.out.println(s));
	
		entityManager.close();
	}

}
