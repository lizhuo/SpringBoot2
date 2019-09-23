package com.cello.aop.aspect;

import com.cello.aop.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-08-04 17:58
 */
@Aspect
@Component
public class AnnotationAop {

    /*@Pointcut(value = "@annotation(log)", argNames = "log")
    public void pointcut(Log log) {
        System.out.println("pointcut");
    }

    @Around(value = "pointcut(log)", argNames = "joinPoint,log")
    public Object around(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
        try {
            System.out.println("log.value: " + log.value());
            System.out.println("around annotation ---");
            Object proceed = joinPoint.proceed();
            System.out.println(proceed);
            return proceed;
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            System.out.println("around annotation finally");
        }
    }*/

    @Before("@annotation(com.cello.aop.annotation.Log)")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        System.out.println("注解式拦截 before " + log.value());

        Object[] args = joinPoint.getArgs();
        Parameter[] parameters = signature.getMethod().getParameters();
        for (int i=0; i<parameters.length; i++) {
            Parameter parameter = parameters[i];
            System.out.println(parameter.getName() + " : " + args[i]);
        }

    }

    @After("@annotation(com.cello.aop.annotation.Log)")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        System.out.println("注解式拦截 after " + log.value());
    }

    @AfterReturning(value = "@annotation(com.cello.aop.annotation.Log)", returning = "object")
    public void afterReturning(Object object) {
        System.out.println("afterReturning annotation: " + object);
    }

}
