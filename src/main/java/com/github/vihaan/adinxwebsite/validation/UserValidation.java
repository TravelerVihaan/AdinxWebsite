package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.users.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userValidation")
public class UserValidation implements IValidation<UserDTO>{

    @Override
    public HttpStatusEnum isValid(UserDTO objectToValidate) {
        return null;
    }
}
