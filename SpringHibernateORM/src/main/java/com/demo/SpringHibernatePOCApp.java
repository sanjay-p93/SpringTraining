package com.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Person;
import com.demo.repository.PersonDao;

public class SpringHibernatePOCApp {

	public static void main(String[] args) {

		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			PersonDao personDao = applicationContext.getBean(PersonDao.class);

			personDao.getAll();
			Person p = new Person("john", "rambo", "john@mail", 27);
			Integer id = personDao.createPerson(p);
			personDao.getById(id);
			personDao.updateEmailById("johnrambo@mail", id);
			personDao.getById(id);
			personDao.getAll();
			personDao.deleteById(id);
			personDao.getAll();
			personDao.averageAge();

			applicationContext.registerShutdownHook();
		}

	}
}
