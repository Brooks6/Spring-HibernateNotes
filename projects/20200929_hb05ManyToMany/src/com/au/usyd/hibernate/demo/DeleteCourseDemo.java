package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Course;
import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Review;
import com.au.usyd.entity.Student;

public class DeleteCourseDemo {

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
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			System.out.println("loaded course: " + tempCourse);
			
			// delete the course
			System.out.println("deleting course: " + tempCourse);
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
