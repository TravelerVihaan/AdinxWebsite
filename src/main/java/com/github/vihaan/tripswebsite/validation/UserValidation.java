package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.tripswebsite.users.UserDTO;
import com.github.vihaan.tripswebsite.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userValidation")
public class UserValidation implements IValidation<UserDTO>{

    private UserRepository userRepository;

    @Autowired
    public UserValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public HttpStatusEnum isValid(UserDTO objectToValidate) {
        return null;
    }
}
