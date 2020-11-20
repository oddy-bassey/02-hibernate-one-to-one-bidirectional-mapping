package com.revoltcode.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revoltcode.demo.entity.Instructor;
import com.revoltcode.demo.entity.InstructorDetail;

public class Application {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating instructor");
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail  = new InstructorDetail("xxxxxxxxxxxxxxxxx", "ooooooooooo");
			instructorDetail.setInstructor(new Instructor("dave","richard","utuba"));
			session.save(instructorDetail);
			
			/*InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			  
		    if(instructorDetail != null){
		    	/*
		    	 * Example of deleting instructorDetail which also does a cascade delete on the associated instructor
		    	 * session.delete(instructorDetail)
		    	 *
		    	
		    	//set the link between the instructor and instructorDetail to successfully delete the instructorDetail without 
		    	//deleting the instructor
		    	instructorDetail.getInstructor().setInstructorDetailId(null);
		    	session.delete(instructorDetail);
		    	
		    	//Fetching the associated instructor details via the bidirectional association
		    	//System.out.println("Instructor--------------------"+instructorDetail.getInstructor().getFirstName());
		    	
		    } else {
		    	System.out.println("User doesn't exist");
		    }*/
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			factory.close();
		}
	}
}
