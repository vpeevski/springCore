package app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.SpringConfiguration;
import impl.Person;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		try {
			
			Person person = context.getBean(Person.class);
			System.out.println(person.getFirstName());
			System.out.println(person.getCar());
			
			person.getCar().drive();
			
			person.getCar().driveTrip();
		} finally {
			context.close();
		}
	}

}