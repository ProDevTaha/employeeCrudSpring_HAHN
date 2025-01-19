package com.hahn.employees.service;

import com.hahn.employees.Exception.GenerateException;
import com.hahn.employees.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(long id);
    List<EmployeeDto> getEmployeesByMultipleCriteria(String fullName, String email, String jobTitle, Date hireDate) throws GenerateException;
    Page<EmployeeDto> getAllEmployees(Pageable page);
    void deleteEmployee(long id);


}
