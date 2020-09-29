package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Course;
import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Review;
import com.au.usyd.entity.Student;

public class GetCoursesForBruceDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the student bruce from database
			int stuId = 2;
			Student tempStudent = session.get(Student.class, stuId);
			
			System.out.println("loaded student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
