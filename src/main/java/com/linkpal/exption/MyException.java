package com.linkpal.exption;

import com.linkpal.domain.entity.Code;
import lombok.Data;

@Data
public class MyException extends RuntimeException{
    private String msg ;
    private int code = Code.FAILED;
    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }
}
