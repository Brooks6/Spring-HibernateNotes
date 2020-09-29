package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("found instructor: " + tempInstructor);
			
			// delete the instructors
			// will also delete associated "details" object
			// because of CascadeType.ALL
			if(tempInstructor != null) {
				System.out.println("deleting: " + tempInstructor);
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			factory.close();
		}
	}

}
