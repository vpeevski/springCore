package impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import api.CarInterface;
import api.PersonInterface;

@Component
public class Person implements PersonInterface {
	
	@Value("${person.firstName}")
	private String firstName;
	
	private String lastName;
	
	@Autowired
	private CarInterface car;
	
	
	public Person (@Value("${person.lastName}") String lastName, CarInterface car) {
		this.lastName = lastName;
		this.car = car;
	}
	
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public CarInterface getCar() {
		return car;
	}

}
