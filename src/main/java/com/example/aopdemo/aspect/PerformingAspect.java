package com.example.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.example.aopdemo.*.*.*(..))")// Will execute before and after
    public Object findExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var currentTimeMillis = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        var stopTimeMilis = System.currentTimeMillis();
        var duration = stopTimeMilis - currentTimeMillis;
        logger.info("Around aspect - Time to execute {} is {} ms",joinPoint.getSignature(), duration);
        return returnValue;
    }
}
