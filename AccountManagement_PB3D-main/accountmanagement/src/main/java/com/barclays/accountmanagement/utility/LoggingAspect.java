package com.barclays.accountmanagement.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.bank.accountmanagementserviceimpls.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		System.out.println("Logging Aspect log service exception called");
		LOGGER.error(exception.getMessage(), exception);
	}

}
