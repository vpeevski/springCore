package impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class EngineStarter {

	@Pointcut("execution(* *.drive()) and this(api.CarInterface)")
	public void driveCar() {
	}
	
	@Pointcut("execution(* *.driveTrip()) and this(api.CarInterface)")
	public void driveCarTrip() {
	}

	@Around("driveCarTrip ()")
	public void startStopSystemForTrip(ProceedingJoinPoint jp) {
		System.out.println();
		System.out.println("###################        Starting a Trip         #########################");
		System.out.println();
		executeAraund(jp);
		
	}

	@Around("driveCar ()")
	public void startStopSystem(ProceedingJoinPoint jp) {
		System.out.println();
		System.out.println("###################        Want just to drive         #########################");
		System.out.println();
		executeAraund(jp);
	}

	private void executeAraund(ProceedingJoinPoint jp) {
		try {
			System.out.println("Check engine ... Succeed !");
			System.out.println("Start engine ... brum brum bruuuum");
			jp.proceed();
			System.out.println("Stop engine ");
		} catch (Throwable e) {
			System.out.println("Go to the service");
		}
	}

}
