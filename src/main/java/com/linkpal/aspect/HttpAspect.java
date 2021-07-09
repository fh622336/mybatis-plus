//package com.linkpal.aspect;
//
//import com.linkpal.domain.entity.Weblog;
//import com.linkpal.mapper.WeblogMapper;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Component
//public class HttpAspect {
//    @Autowired
//    private WeblogMapper weblogMapper;
//    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
//
//    //@Before的注解在方法执行之前执行
//    //拦截该路径下studentList()方法，两个点表示任何参数
////    @Before("execution(public * com.example.controller.StudentController.studentList(..))")
////    public void log(){
////        System.out.println("Test before");
////    }
////
////    @After("execution(public * com.example.controller.StudentController.studentList(..))")
////    public void doAfter(){
////        System.out.println("Test after");
////    }
//
//    //定义一个公用方法
//    @Pointcut("execution(public * com.linkpal.controller.ImageController.*(..))")
//    public void log(){
//    }
//
//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint){
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        Weblog  weblog=new Weblog();
//        weblog.setUrl( request.getRequestURI());
//        weblog.setMethod( request.getMethod());
//        weblog.setIp(request.getRemoteAddr());
//        weblog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        weblogMapper.insert(weblog);
//    }
//
//    @After("log()")
//    public void doAfter(){
//    }
//
//    @AfterReturning(returning="obj", pointcut = "log()")
//    public void doAfterReturnig(Object obj){
//        logger.info("reponse={}", obj);
//    }
//}
