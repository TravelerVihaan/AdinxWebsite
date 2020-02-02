package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.users.UserDTO;
import com.github.vihaan.tripswebsite.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("userValidation")
public class UserValidation implements IValidation<UserDTO>{

    private UserRepository userRepository;

    @Autowired
    public UserValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<String> isValid(UserDTO objectToValidate) {
        List<String> validationErrors = validatorCheck(objectToValidate);
        if(checkIfExistAlready(objectToValidate))
            validationErrors.add(IValidationMessages.DATES_CONFLICT);
        return validationErrors;
    }

    private boolean checkIfExistAlready(UserDTO user){
        return userRepository.findByUsername(user.getUsername()).isPresent();
    }
}
