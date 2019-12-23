package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.users.RoleDTO;
import com.github.vihaan.adinxwebsite.users.RoleRepository;
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
    public HttpStatusEnum isValid(RoleDTO objectToValidate) {
        return null;
    }
}
