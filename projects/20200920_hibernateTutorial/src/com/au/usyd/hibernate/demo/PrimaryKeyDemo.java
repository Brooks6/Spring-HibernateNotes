package com.au.usyd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.usyd.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
						
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					
					// create 3 students object
					System.out.println("creating new student object...");
					Student tempStudent1 = new Student("bruce", "yu", "a@163.com");
					Student tempStudent2 = new Student("watkin", "han", "b@163.com");
					Student tempStudent3 = new Student("eden", "wu", "c@163.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("done!");
				}finally {
					factory.close();
				}
	}

}
