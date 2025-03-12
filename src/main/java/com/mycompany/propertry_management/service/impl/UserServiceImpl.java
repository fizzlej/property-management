package com.mycompany.propertry_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.propertry_management.converter.UserConverter;
import com.mycompany.propertry_management.dto.UserDTO;
import com.mycompany.propertry_management.entity.UserEntity;
import com.mycompany.propertry_management.repository.UserRepository;
import com.mycompany.propertry_management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO resgister(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);

       return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;

       
    }

}
