//package com.example.customer_management_with_restful.Log;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Component
//public class Logger {
////    @AfterReturning()
////    public void log(JoinPoint joinPoint, Exception e) {
////        String className = joinPoint.getTarget().getClass().getSimpleName();
////        String method = joinPoint.getSignature().getName();
////        System.out.println("Phuong thuc duoc goi la: " +className + " " + method);
//////        String args = Arrays.toString(joinPoint.getArgs());
//////        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
////    }
//
//    @AfterThrowing(pointcut = "execution(public * com.example.demo.service.CustomerService.*(..))",
//            throwing = "e")
//    public void logException(JoinPoint joinPoint, Exception e) {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//    }
//}
