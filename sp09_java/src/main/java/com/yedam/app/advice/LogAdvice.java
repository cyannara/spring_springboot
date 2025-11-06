package com.yedam.app.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Log4j2
@Component
public class LogAdvice {

  @Before( "execution(* com.yedam.app..*Impl.*(..))")
  public void logBefore() {
    log.info("========================");
  }
  
  @AfterThrowing(pointcut = "execution(* com.yedam.app..*Impl.*(..))", throwing="exception")
  public void logException(Exception exception) {
    
    log.info("Exception....!!!!");
    log.info("exception: "+ exception);
  
  }
  
  @Around("execution(* com.yedam.app..*Impl.*(..))")
  public Object logTime( ProceedingJoinPoint pjp) {
    
    long start = System.currentTimeMillis();
    
    log.info("Target: " + pjp.getTarget());
    log.info("Param: " + Arrays.toString(pjp.getArgs()));
    
    //invoke method 
    Object result = null;
    
    try {
      result = pjp.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    
    long end = System.currentTimeMillis();
    
    log.info("TIME: "  + (end - start));
    
    return result;
  }



}
