package com.au.usyd.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			displayStudent(theStudents);
			
			//query students: lastName = "bks"
			theStudents = session.createQuery("from Student z where z.lastName = 'bks'").list();
			
			// display the students
			System.out.println("Students who have last name of bks n");
			displayStudent(theStudents);
			
			// query students where email LIKE '%@163.com'
			System.out.println("query students where email LIKE '%@163.com'");
			theStudents = session.createQuery("from Student s where s.email LIKE '%@163.com'").list();
			displayStudent(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
