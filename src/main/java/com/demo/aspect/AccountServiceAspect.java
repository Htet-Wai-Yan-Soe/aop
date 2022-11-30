package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect

public class AccountServiceAspect {
    @Pointcut("this(com.demo.service.AccountService)")
    //@Pointcut("this(com.demo.service.AccountServiceImpl)")   //implement class cant call with this /can only call with target
    public  void  thisPointcutAccountService(){}

    //@Before("thisPointcutAccountService()")
    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(
                String.format("%s'%s is invoked with before advice in (%s)",className,
                        joinPoint.getSignature().getName(),LocalDateTime.now())
        );
    }
}