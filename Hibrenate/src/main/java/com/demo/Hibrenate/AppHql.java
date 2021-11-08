package com.demo.Hibrenate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.Hibrenate.model.Guardian;
import com.demo.Hibrenate.model.Laptop;
import com.demo.Hibrenate.model.Student;

public class AppHql {
	public static void main(String[] args) {

		Student s = new Student();

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Guardian.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();

		// get table
		Query q = session.createQuery("from Guardian");
		List<Guardian> guardians = q.list();
		for (Guardian g : guardians) {
			System.out.println(g);
		}

		System.out.println("\n");

		// unique + where
		Query q2 = session.createQuery("from Guardian where id = :id");
		q2.setParameter("id", 25);
		Guardian guardian25 = (Guardian) q2.uniqueResult();
		System.out.println(guardian25);

		System.out.println("\n");

		// selected columns from the table
		Query q3 = session.createQuery("select id,email from Guardian where age<21");
		List<Object[]> guardians2 = (List<Object[]>) q3.list();
		for (Object[] g : guardians2) {
			System.out.println(g[0] + " : " + g[1]);
		}

		session.getTransaction().commit();
		session.close();

	}
}
