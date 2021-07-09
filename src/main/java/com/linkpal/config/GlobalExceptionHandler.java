//package com.linkpal.config;
//
//import com.linkpal.domain.entity.Response;
//import com.linkpal.exption.MyException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice(basePackages = "com.linkpal.controller")
//public class GlobalExceptionHandler {
//    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//    @ExceptionHandler(value= MyException.class)
//
//    @ResponseBody
//
//    public Response<String> myExceptionErrorHandler(MyException ex) throws Exception {
//
//       logger.error("myExceptionErrorHandler info:{}",ex.getMessage());
//
//        Response<String> r= new Response<>();
//
//        r.setMsg(ex.getMsg());
//
//       r.setCode(ex.getCode());
//
//       return r;
//
//    }
//}
