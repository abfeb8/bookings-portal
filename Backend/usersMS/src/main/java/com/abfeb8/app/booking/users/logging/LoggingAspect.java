package com.abfeb8.app.booking.users.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final String SERVICE_POINT_CUT = "execution(* com.abfeb8.app.booking.users.services..*(..))";
    private static final String CONTROLLER_POINT_CUT = "execution(* com.abfeb8.app.booking.users.controller..*(..))";
    private static final String OR = " || ";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(CONTROLLER_POINT_CUT + OR + SERVICE_POINT_CUT)
    public void applicationPackagePointcut() {}

    @Before("applicationPackagePointcut()")
    public void logMethodExecutionTime(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("USERS_MS :: {} :: {}", methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName());
    }

}
