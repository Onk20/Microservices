package com.lcwd.user.service.exceptions;

public class ResouceNotFoundException extends RuntimeException{


    public ResouceNotFoundException(){
        super("Resouce Not found in system...!!");
    }

    public ResouceNotFoundException(String message){
        super(message);
    }
}
