package com.github.vihaan.tripswebsite.mappers;

import com.github.vihaan.tripswebsite.users.Role;
import com.github.vihaan.tripswebsite.users.RoleDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("roleMapper")
public class RoleMapper implements IMapper<Role, RoleDTO>{

    @Override
    public RoleDTO convertEntityToDto(Role entity) {
        return new RoleDTO(entity.getRole());
    }

    @Override
    public Role convertDtoToEntity(RoleDTO dto) {
        return new Role(dto.getRole());
    }
}
