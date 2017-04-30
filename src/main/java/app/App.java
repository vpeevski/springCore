package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import api.PersonInterface;
import config.SpringConfiguration;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		try {
			
			PersonInterface person = context.getBean(PersonInterface.class);
			System.out.println(person.getFirstName());
			System.out.println(person.getCar());
			
			person.getCar().drive();
			
			person.getCar().driveTrip();
		} finally {
			context.close();
		}
	}

}