package com.github.vihaan.tripswebsite.validation;

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
    public boolean isValid(UserDTO objectToValidate) {
        return false;
    }
}
