package com.example.sys.common;

import lombok.Data;

@Data
public class Result {

    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    private String code;
    private String msg;
    private Object data;


    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setData(data);
        return result;
    }
    public static Result success(String msg){
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }


}
