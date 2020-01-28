package com.github.vihaan.tripswebsite.mappers;

import com.github.vihaan.tripswebsite.users.User;
import com.github.vihaan.tripswebsite.users.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userMapper")
public class UserMapper implements IMapper<User, UserDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO convertEntityToDto(User entity) {
        return null;
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) {
        return null;
    }
}
