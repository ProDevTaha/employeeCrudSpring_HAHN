package com.hahn.employees.dto;

import com.hahn.employees.model.Employee;
import lombok.Data;
import java.util.Date;

@Data
public class EmployeeDto {
    private Long id;
    private String fullName;
    private String employeeId;
    private String jobTitle;
    private String hireDate;
    private String employmentStatus;
    private String email;
    private String phone;
    private String address;

    public static EmployeeDto employeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFullName(employee.getFullName());
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setJobTitle(employee.getJobTitle());
        employeeDto.setHireDate(employee.getHireDate());
        employeeDto.setEmploymentStatus(employee.getEmploymentStatus());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setAddress(employee.getAddress());
        return employeeDto;
    }

    public static Employee employee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFullName(employeeDto.getFullName());
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setEmploymentStatus(employeeDto.getEmploymentStatus());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setAddress(employeeDto.getAddress());
        return employee;
    }
}
