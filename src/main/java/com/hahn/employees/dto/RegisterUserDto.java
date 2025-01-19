package com.hahn.employees.dto;

import com.hahn.employees.model.Role;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;

    private Role role;
}
