package com.demo.Hibrenate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Hibrenate.model.FullName;
import com.demo.Hibrenate.model.Guardian;
import com.demo.Hibrenate.model.Laptop;
import com.demo.Hibrenate.model.Student;

public class App {
	public static void main(String[] args) {

		Guardian g = new Guardian();

		Student s = new Student(5, "john@mail", 20);
		FullName fname = new FullName("john", "rambo");
		s.setFullName(fname);
		s.setGrade("a");

		Laptop l = new Laptop(4, "macbook", 2019);
		Laptop l2 = new Laptop(5, "lenovo", 2015);
		s.setGuardian(g);
		s.getLaptop().add(l);
		s.getLaptop().add(l2);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Guardian.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction txn = session.beginTransaction();
		g = session.get(Guardian.class, 25);
		session.save(l);
		session.save(l2);
		s.setGuardian(g);
		session.save(s);
		txn.commit();
		System.out.println(g);

	}
}
