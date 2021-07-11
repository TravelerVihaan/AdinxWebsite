package com.github.vihaan.tripswebsite.mappers;

import com.github.vihaan.tripswebsite.users.Role;
import com.github.vihaan.tripswebsite.users.RoleDTO;
import com.github.vihaan.tripswebsite.users.User;
import com.github.vihaan.tripswebsite.users.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Qualifier("userMapper")
public class UserMapper implements IMapper<User, UserDTO> {

    private final IMapper<Role, RoleDTO> roleMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(@Qualifier("roleMapper") IMapper<Role, RoleDTO> roleMapper,
                      ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDTO convertEntityToDto(User entity) {
        Set<RoleDTO> rolesDTO = entity.getRoles()
                .stream()
                .map(roleMapper::convertEntityToDto)
                .collect(Collectors.toSet());
        UserDTO userDTO = modelMapper.map(entity, UserDTO.class);
        userDTO.setRoles(rolesDTO);
        return userDTO;
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        Set<Role> roles = dto.getRoles()
                .stream()
                .map(roleMapper::convertDtoToEntity)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return user;
    }
}
