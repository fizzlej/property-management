package com.mycompany.propertry_management.service;

import com.mycompany.propertry_management.dto.UserDTO;

public interface UserService {

    UserDTO resgister(UserDTO userDTO);
    UserDTO login(String email, String password);
}
