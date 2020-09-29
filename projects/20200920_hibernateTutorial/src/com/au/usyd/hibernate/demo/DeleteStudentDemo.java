package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 2;
			
			// start a transaction
			session.beginTransaction();
			
			// get a id for deleting
			Student theStudent = session.get(Student.class, studentId);
			session.delete(theStudent);
			session.getTransaction().commit();
			
			// delete data according to a stdID
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id = 3").executeUpdate();
			session.getTransaction().commit();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			factory.close();
		}
	}

}
