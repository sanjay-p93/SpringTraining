package com.demo.Hibrenate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.demo.Hibrenate.model.Guardian;
import com.demo.Hibrenate.model.Laptop;
import com.demo.Hibrenate.model.Student;

public class AppSql {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Guardian.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();

		// getting entire raw

		Session session = sf.openSession();
		session.beginTransaction();

		NativeQuery q = session.createSQLQuery("select * from student where age < :age");
		q.addEntity(Student.class);
		q.setParameter("age", 21);
		List<Student> students = q.list();
		for (Student s : students) {
			System.out.println(s);
		}

		session.getTransaction().commit();

		// getting selected columns

		Session session2 = sf.openSession();
		session2.beginTransaction();

		String sql = "SELECT id, email FROM student where age<10";
		NativeQuery<Object[]> query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Object[]> data = query.list();

		for (Object object : data) {
			Map row = (Map) object;
			System.out.print(row.get("id") + " : " + row.get("email") + "\n");
		}

		session2.getTransaction().commit();
		session2.close();

	}
}
