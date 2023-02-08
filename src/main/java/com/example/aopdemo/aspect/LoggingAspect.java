package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Example - execution(* PACKAGE.*.METHOD(..))
    @Before("execution(* com.example.aopdemo.*.*.*(..))") //Pointcut - when?
    public void logMethodCallBefore(JoinPoint joinPoint) {
        logger.info("Before aspect - Method is called - {}", joinPoint.getSignature()); //Advice - what?
    }
    //Weaver - AspectJ or Spring AOP

    @After("execution(* com.example.aopdemo.data.*.*(..))")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        logger.info("After aspect - Method - {} has executed", joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.example.aopdemo.*.*.*(..))", throwing = "exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing aspect - Method - {} has throwing an exception {}", joinPoint.getSignature(), exception);
    }
}
