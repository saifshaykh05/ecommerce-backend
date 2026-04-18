package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.dto.UserRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.UserResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public UserResponseDTO registerUser(UserRequestDTO user);
    public List<UserResponseDTO> getAllUser();
    public UserResponseDTO getByEmail(String email);
    public UserResponseDTO getUserById(Long id);
}
