package com.pgrsoft.springbatchlab.ejemplo02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Job2PersonProcessor implements ItemProcessor<Person,Person> {

	private static final Logger log = LoggerFactory.getLogger(Job2PersonProcessor.class);
	
	
	@Override
	public Person process(Person item) throws Exception {
		
		Thread.sleep(500);
		
		final String firstName = item.getFirstName().toUpperCase();
		final String lastName = item.getLastName().toUpperCase();
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		log.info("transformed person: " + person);
		
		return person;
	}

}
