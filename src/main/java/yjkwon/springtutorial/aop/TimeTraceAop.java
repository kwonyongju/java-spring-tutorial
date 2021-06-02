package yjkwon.springtutorial.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* yjkwon.springtutorial..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long timeInMs = end - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeInMs + "ms");
        }
    }
}
