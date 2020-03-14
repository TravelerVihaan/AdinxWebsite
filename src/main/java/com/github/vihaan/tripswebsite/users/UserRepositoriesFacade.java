package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class UserRepositoriesFacade {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private IMapper<Role, RoleDTO> roleMapper;
    private IMapper<User, UserDTO> userMapper;

    @Autowired
    UserRepositoriesFacade(@Qualifier("roleMapper") IMapper<Role, RoleDTO> roleMapper,
                                  @Qualifier("userMapper")IMapper<User, UserDTO> userMapper,
                                  UserRepository userRepository,
                                  RoleRepository roleRepository
                                  ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userMapper = userMapper;
    }

    private IMapper<Role, RoleDTO> getRoleMapper(){
        return roleMapper;
    }

    private IMapper<User, UserDTO> getUserMapper(){
        return userMapper;
    }

    Optional<UserDTO> getUserDtoByUsername(String username) {
        try {
            User user = userRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
            return Optional.of(userMapper.convertEntityToDto(user));
        }catch(NoSuchElementException e){
            return Optional.empty();
        }
    }

    List<UserDTO> getAllUserDtos(){
        return userRepository
                .findAll()
                .stream()
                .map(user -> userMapper.convertEntityToDto(user))
                .collect(Collectors.toList());
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
