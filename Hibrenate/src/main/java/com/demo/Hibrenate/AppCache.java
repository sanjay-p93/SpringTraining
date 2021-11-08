package com.demo.Hibrenate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.Hibrenate.model.Guardian;
import com.demo.Hibrenate.model.Laptop;
import com.demo.Hibrenate.model.Student;

public class AppCache {
	public static void main(String[] args) {

		Student s = new Student();

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Guardian.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();

		// session 1
		Session session = sf.openSession();
		session.beginTransaction();

		s = session.get(Student.class, 1);
		System.out.println(s);
		s = session.get(Student.class, 1);
		System.out.println(s);

		session.getTransaction().commit();
		session.close();

		// session 2
		Session session2 = sf.openSession();
		session2.beginTransaction();

		s = session2.get(Student.class, 1);
		System.out.println(s);

		session2.getTransaction().commit();
		session2.close();
	}
}
