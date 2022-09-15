package com.xmen.api.dto;

import java.util.List;

public class ReturnDTO {
    private Long code;
    private String message;
    private Object object;
    private List<Object> objects;
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
    
    
}
