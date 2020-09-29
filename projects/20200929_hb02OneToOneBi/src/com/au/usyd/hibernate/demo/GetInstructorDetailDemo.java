package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Student;

public class GetInstructorDetailDemo {

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
			
			// get instructorDetail by primary key / id
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("found instructorDetail: " + tempInstructorDetail);
			
			// get instructor
			if(tempInstructorDetail != null) {
				System.out.println("the instructor is: " + tempInstructorDetail.getInstructor());
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
