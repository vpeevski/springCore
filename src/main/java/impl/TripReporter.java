package impl;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class TripReporter {
	
	@Pointcut("execution(* *.driveTrip()) and this(api.CarInterface)")
	public void driveCarTrip() {
	}
	
	@AfterReturning(pointcut = "driveCarTrip ()", returning = "tripKilometers")
	public void reportTripLenght (Object tripKilometers) {
		System.out.println("Last trip was " + tripKilometers + " km.");
	}

}
