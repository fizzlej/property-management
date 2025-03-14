package com.mycompany.propertry_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.propertry_management.converter.UserConverter;
import com.mycompany.propertry_management.dto.UserDTO;
import com.mycompany.propertry_management.entity.UserEntity;
import com.mycompany.propertry_management.exception.BusinessException;
import com.mycompany.propertry_management.exception.ErrorModel;
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

        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email you are trying to resgister with alresdy exist.");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);

       return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()){
           userDTO = userConverter.convertEntityToDTO(optionalUserEntity.get()); 
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;

       
    }

}
