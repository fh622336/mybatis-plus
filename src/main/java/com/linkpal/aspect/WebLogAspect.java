//package com.linkpal.aspect;
//
//import com.google.gson.Gson;
//import com.linkpal.domain.entity.Weblog;
//import com.linkpal.mapper.WeblogMapper;
//import eu.bitwalker.useragentutils.UserAgent;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Aspect
//@Component
//public class WebLogAspect {
//    @Autowired
//    private WeblogMapper weblogMapper;
//    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
//    /** 以 controller 包下定义的所有请求为切入点 */
//    @Pointcut("execution(public * com.linkpal.controller..*.*(..))")
//    public void webLog() {}
//    /**
//     * 在切点之前织入
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 开始打印请求日志
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//        // 打印请求相关参数
//        logger.info("========================================== Start ==========================================");
//        // 打印请求 url
//        logger.info("URL            : {}", request.getRequestURL().toString());
//        // 打印 Http method
//        logger.info("HTTP Method    : {}", request.getMethod());
//        // 打印调用 controller 的全路径以及执行方法
//        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//        // 打印请求的 IP
//        logger.info("IP             : {}", request.getRemoteAddr());
//        // 打印请求入参
//        logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
//        logger.info("浏览器 : {}", userAgent.getBrowser().toString());
//        logger.info("浏览器版本 : {}", userAgent.getBrowserVersion());
//        logger.info("操作系统: {}", userAgent.getOperatingSystem().toString());
//        Weblog weblog=new Weblog();
//        weblog.setUrl( request.getRequestURI());
//        weblog.setMethod( request.getMethod());
//        weblog.setIp(request.getRemoteAddr());
//        weblog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        weblog.setArgs(new Gson().toJson(joinPoint.getArgs()));
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = df.format(LocalDateTime.now());
//        weblog.setCreatime(format);
//        weblog.setBrowser( userAgent.getBrowser().toString());
//        weblog.setVersion(userAgent.getBrowserVersion().toString());
//        weblog.setSystem(userAgent.getOperatingSystem().toString());
//        weblogMapper.insert(weblog);
//    }
//    /**
//     * 在切点之后织入
//     * @throws Throwable
//     */
//    @After("webLog()")
//    public void doAfter() throws Throwable {
//        logger.info("=========================================== End ===========================================");
//        // 每个请求之间空一行
//        logger.info("");
//    }
//    /**
//     * 环绕
//     * @param proceedingJoinPoint
//     * @return
//     * @throws Throwable
//     */
//    @Around("webLog()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        // 打印出参
//        logger.info("Response Args  : {}", new Gson().toJson(result));
//        // 执行耗时
//        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
//
//        return result;
//    }
//}
