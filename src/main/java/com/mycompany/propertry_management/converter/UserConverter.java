package com.mycompany.propertry_management.converter;

import org.springframework.stereotype.Component;

import com.mycompany.propertry_management.dto.UserDTO;
import com.mycompany.propertry_management.entity.UserEntity;

@Component
public class UserConverter {

    public UserEntity convertDTOToEntity(UserDTO userDTO){

        UserEntity userEntity = new UserEntity();

        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());

        return userEntity;

    }
    public UserDTO convertEntityToDTO(UserEntity userEntity){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());

        return userDTO;
    }

}
