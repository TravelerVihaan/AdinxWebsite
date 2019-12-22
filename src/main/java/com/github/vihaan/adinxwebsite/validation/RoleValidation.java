package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.users.Role;
import com.github.vihaan.adinxwebsite.users.RoleDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("roleValidation")
public class RoleValidation implements IValidation<RoleDTO>{
    @Override
    public HttpStatusEnum isValid(RoleDTO objectToValidate) {
        return null;
    }
}
