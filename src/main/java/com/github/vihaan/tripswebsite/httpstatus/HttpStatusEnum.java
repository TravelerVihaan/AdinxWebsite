package com.github.vihaan.tripswebsite.httpstatus;

import org.springframework.http.HttpStatus;

public enum HttpStatusEnum {
    OK(HttpStatus.OK),
    CONFLICT(HttpStatus.CONFLICT),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    CREATED(HttpStatus.CREATED);

    HttpStatus response;

    HttpStatusEnum(HttpStatus response){
        this.response = response;
    }

    public HttpStatus getResponse(){
        return response;
    }

}