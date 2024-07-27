package com.arclaudio.todo.service;

import com.arclaudio.todo.dto.LoginDTO;
import com.arclaudio.todo.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);
}
