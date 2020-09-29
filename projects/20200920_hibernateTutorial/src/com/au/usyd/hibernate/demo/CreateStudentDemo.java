package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("creating new student object...");
			Student tempStudent = new Student("z23", "bks", "liuhongzhang1996@163.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			factory.close();
		}
	}

}
