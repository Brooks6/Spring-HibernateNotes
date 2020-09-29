package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Course;
import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Review;
import com.au.usyd.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("NBA");
			
			// add some reviews
			tempCourse.addReview(new Review("goodgood"));
			tempCourse.addReview(new Review("badbad"));
			tempCourse.addReview(new Review("ezez"));
			
			// save the course ... and leverage the cascade all
			// use cascade feature also save reviews
			session.save(tempCourse);
			System.out.println("saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
