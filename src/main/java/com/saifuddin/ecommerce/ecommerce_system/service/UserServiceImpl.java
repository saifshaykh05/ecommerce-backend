package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.dto.UserRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.UserResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.entity.User;
import com.saifuddin.ecommerce.ecommerce_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponseDTO registerUser(UserRequestDTO Ruser){
        User existuser= userRepository.findByEmail(Ruser.getEmail());
        if(existuser!=null){
            throw new RuntimeException("Email already Exist..");
        }
        User user =new User(Ruser.getName(),Ruser.getPassword(), Ruser.getEmail(), Ruser.getRole());
        userRepository.save(user);
        UserResponseDTO responseuser=new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
        return responseuser;
    }
    @Override
    public List<UserResponseDTO> getAllUser(){
        List<User> users=userRepository.findAll();
        List<UserResponseDTO> responseList = new ArrayList<>();
        for(User user: users){
            UserResponseDTO dto=new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
            responseList.add(dto);
        }
        return responseList;
    }
    @Override
    public UserResponseDTO getByEmail(String email){
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new RuntimeException("Email User not found");
        }
        UserResponseDTO dto=new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
        return dto;
    }
    @Override
    public UserResponseDTO getUserById(Long id){
        User user=userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Id does not exist..")
        );
        UserResponseDTO dto =new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
        return dto;
    }
}
