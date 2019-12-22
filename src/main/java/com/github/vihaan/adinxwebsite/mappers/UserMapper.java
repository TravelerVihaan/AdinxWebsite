package com.github.vihaan.adinxwebsite.mappers;

import com.github.vihaan.adinxwebsite.users.User;
import com.github.vihaan.adinxwebsite.users.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userMapper")
public class UserMapper implements IMapper<User, UserDTO> {
    @Override
    public UserDTO convertEntityToDto(User entity) {
        return null;
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) {
        return null;
    }
}
