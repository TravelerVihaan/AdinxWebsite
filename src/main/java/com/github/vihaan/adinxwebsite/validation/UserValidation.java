package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.users.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("destinationValidation")
public class UserValidation implements IValidation<User>{
    @Override
    public HttpStatusEnum isValid(User objectToValidate) {
        return null;
    }
}
