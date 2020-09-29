package com.au.usyd.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentID = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// retrieve student from database
			Student myStudent = session.get(Student.class, studentID);
			
			// update
			myStudent.setLastName("empty");
			
			// commit transaction
			session.getTransaction().commit();
			
			// display this student
			System.out.println(myStudent);
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update
			session.createQuery("update Student set email = '@gmail.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			// display student
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").list();
			displayStudent(theStudents);
			
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
