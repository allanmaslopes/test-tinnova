package com.br.tinnova.service;

import com.br.tinnova.model.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     UserResponseDTO findByUsername(String username, String password);
}
