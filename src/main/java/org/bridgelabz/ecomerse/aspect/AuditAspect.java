package org.bridgelabz.ecomerse.aspect;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.bridgelabz.ecomerse.repository.AllInOne;
import org.hibernate.audit.AuditLog;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    private final AllInOne allInOne;

    public AuditAspect(AllInOne allInOne) {
        this.allInOne=allInOne;
    }

    @Around("execution(* org.bridgelabz.ecomerse.*..*(..))")
    public Object audit(ProceedingJoinPoint joinPoint)
            throws Throwable {



        String methodName =
                joinPoint.getSignature().getName();

        Object[] args =
                joinPoint.getArgs();

        try {

            Object result = joinPoint.proceed();

            allInOne.save();

            return result;

        } catch (Exception e) {

            throw e;
        }
    }
}
