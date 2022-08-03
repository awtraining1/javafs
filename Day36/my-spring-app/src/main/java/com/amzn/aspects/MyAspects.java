package com.amzn.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspects {

	@Around("execution(* com.amzn.beans.*.*(..))")
	public void measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// Code to execute before the method
		System.out.println("Inside Aspect measureTime " + joinPoint.getSignature());
		Instant startTime = Instant.now();

		// method call happens now
		joinPoint.proceed();

		// Code to execute after the method call is over
		Instant endTime = Instant.now();
		System.out.println(" Time taken in nano secs: " + Duration.between(startTime, endTime).toNanos());
	}

	// 36B Write a new aspect which applies to only Retailer class.
	@Around("execution(* com.amzn.beans.Retailer.*(..))")
	public void measureTime2(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Aspect measureTime2 " + joinPoint.getSignature());
		joinPoint.proceed();
		System.out.println("End of measureTime2 " + joinPoint.getSignature());
	}

	// 36C Write a new aspect which applies to only Retailer's abc method.
	@Around("execution(* com.amzn.beans.Retailer.abc(..))")
	public void measureTime3(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Aspect measureTime3 " + joinPoint.getSignature());
		joinPoint.proceed();
		System.out.println("End of measureTime3 " + joinPoint.getSignature());
	}

	// 36D Write a new aspect which applies to only Retailer's methods which
	// startwith xyz.
	@Around("execution(* com.amzn.beans.Retailer.xyz*(..))")
	public void measureTime4(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Aspect measureTime4 " + joinPoint.getSignature());
		joinPoint.proceed();
		System.out.println("End of measureTime4 " + joinPoint.getSignature());
	}

	// 36D Write a new aspect which applies to only Retailer's methods which
	// startwith PQR and accept two arguments String and int.
	@Around(value="execution(* com.amzn.beans.Retailer.PQR*(String,int))")
	public void measureTime5(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Aspect measureTime5 " + joinPoint.getSignature());
		joinPoint.proceed();
		System.out.println("End of measureTime5 " + joinPoint.getSignature());
	}
	
	// 36E Write a new aspect which applies to only Retailer's methods
	// and called only BEFORE the method is executed
	@Before(value="execution(* com.amzn.beans.Retailer.*(..))")
	public void measureTime6(JoinPoint joinPoint) throws Throwable {
		System.out.println("Inside @before type Aspect measureTime6 " + joinPoint.getSignature());
		;
	}
	
	@After(value="execution(* com.amzn.beans.Retailer.*(..))")
	public void measureTime7(JoinPoint joinPoint) throws Throwable {
		System.out.println("Inside @after type Aspect measureTime7 " + joinPoint.getSignature());
		;
	}
	
	// We can specifially write advice for methods whenever they thrown an exception
    // If no exception is thrown then this advice will NOT run.
    @AfterThrowing(value = "execution(* com.amzn.beans.*.setAge(..))", throwing = "ex")
    public void measureTime9AfterThrowing(JoinPoint joinPoint, Object ex) throws Throwable {
        System.out.println("Inside Aspect anAspectForAfterThrowing " + joinPoint.getSignature());
        System.out.println("Inside Aspect anAspectForAfterThrowing. Exception is " + ex);
    }
    
 // We can specifially write advice for methods that return some value
    @AfterReturning(value = "execution(* com.amzn.beans.*.getName(..))", returning = "retVal")
    public void anAspectForAfterReturning(JoinPoint joinPoint, Object retVal) throws Throwable {
        System.out.println("Inside Aspect anAspectForAfterReturning " + joinPoint.getSignature());
        System.out.println("Inside Aspect anAspectForAfterReturning return value is  " + retVal);
    }

}
