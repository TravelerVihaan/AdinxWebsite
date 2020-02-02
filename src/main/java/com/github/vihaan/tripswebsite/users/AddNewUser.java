package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import com.github.vihaan.tripswebsite.validation.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddNewUser {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private IMapper<User, UserDTO> userMapper;
    private IValidation<UserDTO> userValidator;

    @Autowired
    public AddNewUser(@Qualifier("userMapper") IMapper userMapper,
                      @Qualifier("userValidation") IValidation userValidator,
                      UserRepository userRepository,
                      RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    public void addNewUser(UserDTO userDTO){
        if(!userValidator.isValid(userDTO))
            return; //TODO
        userDTO.setRegisterDate(LocalDateTime.now());
        User user = userMapper.convertDtoToEntity(userDTO);
        Set<RoleDTO> rolesDtoSet = userDTO.getRoles();
        Set<Role> roles = rolesDtoSet.stream().map(role -> findAndConvertToRole(role.getRole())).collect(Collectors.toSet());
        user.setRoles(roles);
        userRepository.save(user);
    }

    private Role findAndConvertToRole(String role){
        return roleRepository.findByRole(role).orElseThrow();
    }
}
