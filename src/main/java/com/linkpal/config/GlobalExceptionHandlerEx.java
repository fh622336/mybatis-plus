package com.linkpal.config;

import com.linkpal.domain.entity.Code;
import com.linkpal.domain.entity.Response;
import com.linkpal.exption.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandlerEx {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerEx.class);
    @ExceptionHandler(value= BindException.class)
    @ResponseBody
    public Response bindExceptionErrorHandler(BindException   ex) throws Exception {
       logger.error("myExceptionErrorHandler info:{}",ex.getMessage());
        StringBuilder sb = new StringBuilder();
        FieldError fieldError = ex.getFieldError();
        sb.append(fieldError.getDefaultMessage());
       return Response.fail(Code.FAILED,sb.toString(),null);
    }

    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Response ExceptionErrorHandler(Exception   ex) throws Exception {

        logger.error("Exception info:{}",ex.getMessage());


        StringBuilder sb = new StringBuilder();
        String message = ex.getMessage();
        sb.append(message);
        return Response.fail(Code.FAILED,sb.toString(),null);
    }
}
