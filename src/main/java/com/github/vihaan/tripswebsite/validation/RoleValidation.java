package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.users.RoleDTO;
import com.github.vihaan.tripswebsite.users.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("roleValidation")
public class RoleValidation implements IValidation<RoleDTO>{

    private RoleRepository roleRepository;

    @Autowired
    public RoleValidation(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean isValid(RoleDTO objectToValidate) {
        if(!validatorCheck(objectToValidate)){
            return false;
        }
        return true;
    }
}
