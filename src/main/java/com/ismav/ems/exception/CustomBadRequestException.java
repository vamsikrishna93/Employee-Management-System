package com.ismav.ems.exception;

public class CustomBadRequestException extends Exception{
    public CustomBadRequestException(String msg){
        super(msg);
    }
}
