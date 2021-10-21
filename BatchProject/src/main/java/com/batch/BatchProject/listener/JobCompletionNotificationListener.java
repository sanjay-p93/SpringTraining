package com.batch.BatchProject.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.BatchProject.model.Person;
import com.batch.BatchProject.repository.PersonRepository;


@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private PersonRepository personRepository;

	@Autowired
	public JobCompletionNotificationListener(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}


	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<Person> results = personRepository.findAll();

			for (Person person : results) {
				log.info("Found <" + person + "> in the database.");
			}

		}
	}
}