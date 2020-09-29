package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Course;
import com.au.usyd.entity.Instructor;
import com.au.usyd.entity.InstructorDetail;
import com.au.usyd.entity.Review;
import com.au.usyd.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Z23");
			
			System.out.println("saving the course...");
			session.save(tempCourse);
			System.out.println("saved the course...");
			
			// create the students
			Student tempStudent1 = new Student("bruce", "yu", "yu@163.com");
			Student tempStudent2 = new Student("watken", "xu", "wk@163.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("saving students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved students " + tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
