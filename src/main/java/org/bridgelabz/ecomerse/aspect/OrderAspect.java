package org.bridgelabz.ecomerse.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {

    @Before("execution(* org.bridgelabz.ecomerse.service.OrderService.*(..))")
    public void beforeMethod(){
        System.out.println("Before methodd");

    }

    @Around("execution(* org.bridgelabz.ecomerse.service.OrderService.*(..))")
    public void arroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
        joinPoint.proceed();
        System.out.println("after");

    }
}
