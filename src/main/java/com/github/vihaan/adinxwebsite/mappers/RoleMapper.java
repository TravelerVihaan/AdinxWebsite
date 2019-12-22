package com.github.vihaan.adinxwebsite.mappers;

import com.github.vihaan.adinxwebsite.users.Role;
import com.github.vihaan.adinxwebsite.users.RoleDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("roleMapper")
public class RoleMapper implements IMapper<Role, RoleDTO>{
    @Override
    public RoleDTO convertEntityToDto(Role entity) {
        return null;
    }

    @Override
    public Role convertDtoToEntity(RoleDTO dto) {
        return null;
    }
}
