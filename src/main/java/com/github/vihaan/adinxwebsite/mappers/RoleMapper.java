package com.github.vihaan.adinxwebsite.mappers;

import com.github.vihaan.adinxwebsite.users.Role;
import com.github.vihaan.adinxwebsite.users.RoleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("roleMapper")
public class RoleMapper implements IMapper<Role, RoleDTO>{

    private ModelMapper modelMapper;

    @Autowired
    public RoleMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleDTO convertEntityToDto(Role entity) {
        return null;
    }

    @Override
    public Role convertDtoToEntity(RoleDTO dto) {
        return null;
    }
}
