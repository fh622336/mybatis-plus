//package com.linkpal.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Aspect
//public class RequestLogAspect {
//    private final static Logger LOGGER = LoggerFactory.getLogger(RequestLogAspect.class);
//
//    @Pointcut("execution(* com.linkpal.controller..*(..))")
//    public void requestServer() {
//    }
//
//    @Before("requestServer()")
//    public   void doBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes)
//                RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        LOGGER.info("===============================Start========================");
//        LOGGER.info("IP                 : {}", request.getRemoteAddr());
//        LOGGER.info("URL                : {}", request.getRequestURL().toString());
//        LOGGER.info("HTTP Method        : {}", request.getMethod());
//        LOGGER.info("Class Method       : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName());
//    }
//
//
//    @Around("requestServer()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        LOGGER.info("Request Params     : {}", getRequestParams(proceedingJoinPoint));
//        LOGGER.info("Result               : {}", result);
//        LOGGER.info("Time Cost            : {} ms", System.currentTimeMillis() - start);
//
//        return result;
//    }
//
//    @After("requestServer()")
//    public void doAfter(JoinPoint joinPoint) {
//        LOGGER.info("===============================End========================");
//    }
//
//    /**
//     * ????????????
//     * @param proceedingJoinPoint
//     *
//     * @return
//     * */
//    private Map<String, Object> getRequestParams(ProceedingJoinPoint proceedingJoinPoint) {
//        Map<String, Object> requestParams = new HashMap<>();
//
//        //?????????
//        String[] paramNames =
//                ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
//        //?????????
//        Object[] paramValues = proceedingJoinPoint.getArgs();
//
//        for (int i = 0; i < paramNames.length; i++) {
//            Object value = paramValues[i];
//
//            //?????????????????????
//            if (value instanceof MultipartFile) {
//                MultipartFile file = (MultipartFile) value;
//                value = file.getOriginalFilename();  //???????????????
//            }
//
//            requestParams.put(paramNames[i], value);
//        }
//
//        return requestParams;
//    }
//}
