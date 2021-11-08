package com.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Person;

@Repository
public class PersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void getAll() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			System.out.println("\n Get all person");
			Query query = session.createQuery("from Person");
			List<Person> list = query.list();

			for (Person p : list) {
				System.out.println(p);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getById(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			System.out.println("\n Get person by id : " + id);
			Query q = session.createQuery("from Person where id = :id");
			q.setParameter("id", id);
			Person p = (Person) q.uniqueResult();
			System.out.println(p);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Integer createPerson(Person person) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Integer id = (Integer) session.save(person);
			System.out.println("\n Created person with id : " + id);
			session.getTransaction().commit();

			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateEmailById(String email, Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query q = session.createQuery("update Person set email=:e where id=:i");
			q.setParameter("e", email);
			q.setParameter("i", id);

			int status = q.executeUpdate();
			System.out.println("\n Email upate status: " + status);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query q = session.createQuery("delete from Person where id=:i");
			q.setParameter("i", id);

			int status = q.executeUpdate();
			System.out.println("\n Delete status : " + status);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void averageAge() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query q = session.createQuery("select avg(age) from Person");
			Double avgAge = (Double) q.uniqueResult();
			System.out.println("\n Average Age : " + avgAge);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
