package com.mycompany.propertry_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.propertry_management.dto.UserDTO;
import com.mycompany.propertry_management.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    
@PostMapping("/register")
public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO){

    userDTO = userService.resgister(userDTO);
    return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    
}
@PostMapping("/login")
public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO){

    userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  
}

}
