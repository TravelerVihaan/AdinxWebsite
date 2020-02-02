package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class UserRepositoriesFacade {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private IMapper<Role, RoleDTO> roleMapper;
    private IMapper<User, UserDTO> userMapper;

    @Autowired
    UserRepositoriesFacade(@Qualifier("roleMapper") IMapper roleMapper,
                                  @Qualifier("userMapper")IMapper userMapper,
                                  UserRepository userRepository,
                                  RoleRepository roleRepository
                                  ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    IMapper getRoleMapper(){
        return roleMapper;
    }

    IMapper getUserMapper(){
        return userMapper;
    }

    UserDTO getUserDtoByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow();
        return userMapper.convertEntityToDto(user);
    }

    Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    RoleDTO getRoleDtoByRoleName(String roleName){
        Role role = roleRepository.findByRole(roleName).orElseThrow();
        return roleMapper.convertEntityToDto(role);
    }

    Optional<Role> getRoleByRoleName(String roleName) {
        return roleRepository.findByRole(roleName);
    }

    void saveUser(User user){
        userRepository.save(user);
    }

    void saveRole(Role role){
        roleRepository.save(role);
    }
}
