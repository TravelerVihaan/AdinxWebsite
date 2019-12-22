package com.github.vihaan.adinxwebsite.httpstatus;

import org.springframework.http.HttpStatus;

public enum HttpStatusEnum {
    OK(HttpStatus.OK),
    CONFLICT(HttpStatus.CONFLICT),
    BADREQUEST(HttpStatus.BAD_REQUEST),
    NOTFOUND(HttpStatus.NOT_FOUND),
    CREATED(HttpStatus.CREATED);

    HttpStatus response;

    HttpStatusEnum(HttpStatus response){
        this.response = response;
    }

    HttpStatus getResponse(){
        return response;
    }

}