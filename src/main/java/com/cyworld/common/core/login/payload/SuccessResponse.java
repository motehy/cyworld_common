package com.cyworld.common.core.login.payload;

import lombok.Data;

@Data
public class SuccessResponse {
    private int code;
    private String message;
    private Object obj; //return 될 값
    private Object obj2; //return 될 값

    public SuccessResponse(int code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }
    
    public SuccessResponse(int code, String message, Object obj, Object obj2) {
    	this.code = code;
        this.message = message;
        this.obj = obj;
        this.obj2 = obj2;
    }
    
    public static SuccessResponse success(String message, Object obj) {
        return new SuccessResponse(200, message, obj);
    }
    
    public static SuccessResponse failed(int code, String message) {
        return new SuccessResponse(code, message, null);
    }

}
