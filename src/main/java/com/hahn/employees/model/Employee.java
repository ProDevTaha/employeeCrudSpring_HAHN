package com.hahn.employees.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Full Name is required")
    private String fullName;
    @NotNull(message = "Employee ID is required")
    private String employeeId;
    @NotNull(message = "Job title is required")
    private String jobTitle;
    @Pattern(regexp = "\\d{4}/\\d{2}/\\d{2}", message = "Hire date must be in the format YYYY/MM/DD")
    private String hireDate;
    private String employmentStatus;
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "Phone is required")
    private String phone;
    @NotNull(message = "Address is required")
    private String address;
}
