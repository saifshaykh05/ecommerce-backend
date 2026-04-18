package com.saifuddin.ecommerce.ecommerce_system.controller;

import com.saifuddin.ecommerce.ecommerce_system.dto.StandardApiResponse;
import com.saifuddin.ecommerce.ecommerce_system.dto.UserRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.UserResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.entity.User;
import com.saifuddin.ecommerce.ecommerce_system.service.UserService;
import com.saifuddin.ecommerce.ecommerce_system.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<StandardApiResponse<UserResponseDTO>> getregister(@Valid @RequestBody UserRequestDTO Ruser){
        UserResponseDTO user=userService.registerUser(Ruser);
        StandardApiResponse<UserResponseDTO> apiResponse=new StandardApiResponse<>("Success","Register user successfuly",user);
        return  ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/getalluser")
    public List<UserResponseDTO> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/getbyemail")
    public UserResponseDTO getbyemail(@Valid @RequestParam String email){
        return userService.getByEmail(email);
    }
    @GetMapping("/getbyid/{id}")
    public UserResponseDTO getbyid(@PathVariable Long id){
        return userService.getUserById(id);
    }
}

