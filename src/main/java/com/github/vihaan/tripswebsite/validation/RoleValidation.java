package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.users.RoleDTO;
import com.github.vihaan.tripswebsite.users.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("roleValidation")
public class RoleValidation implements IValidation<RoleDTO>{

    private RoleRepository roleRepository;

    @Autowired
    public RoleValidation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<String> isValid(RoleDTO objectToValidate) {
        List<String> validationErrors = validatorCheck(objectToValidate);
        if(checkIfExistAlready(objectToValidate))
            validationErrors.add(IValidationMessages.DB_CONFLICT);
        return validationErrors;
    }

    private boolean checkIfExistAlready(RoleDTO role){
        return roleRepository.findByRole(role.getRole()).isPresent();

    }
}
