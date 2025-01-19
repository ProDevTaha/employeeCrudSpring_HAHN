package com.hahn.employees.service.serviceImp;

import com.hahn.employees.Exception.GenerateException;
import com.hahn.employees.Exception.ResourceNotFoundException;
import com.hahn.employees.dto.EmployeeDto;
import com.hahn.employees.model.Employee;
import com.hahn.employees.repository.EmployeeRepository;
import com.hahn.employees.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeImplement implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) throws GenerateException {
        try {
            Employee employee = EmployeeDto.employee(employeeDto);
            Employee savedEmployee =  employeeRepository.save(employee);
            return EmployeeDto.employeeDto(savedEmployee);
        } catch (GenerateException e) {
            throw new GenerateException("Error when create employee :" + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws GenerateException , ResourceNotFoundException{
        try {
            Employee employee = employeeRepository.findById(employeeDto.getId())
                    .orElseThrow(()->new ResourceNotFoundException("Employee not found" , employeeDto.getId()));
            Optional.ofNullable(employeeDto.getAddress()).ifPresent(employee::setAddress);
            Optional.ofNullable(employeeDto.getEmail()).ifPresent(employee::setEmail);
            Optional.ofNullable(employeeDto.getPhone()).ifPresent(employee::setPhone);
            Optional.ofNullable(employeeDto.getFullName()).ifPresent(employee::setFullName);
            Optional.ofNullable(employeeDto.getEmploymentStatus()).ifPresent(employee::setEmploymentStatus);
            Optional.ofNullable(employeeDto.getJobTitle()).ifPresent(employee::setJobTitle);
            Optional.ofNullable(employeeDto.getHireDate()).ifPresent(employee::setHireDate);

            Employee employeeSaved = employeeRepository.save(employee);
            return EmployeeDto.employeeDto(employeeSaved);
        } catch (GenerateException e) {
            throw new GenerateException("Error when create employee :" + e.getMessage(), e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(long id) throws GenerateException , ResourceNotFoundException {
       try {
           Employee employee = employeeRepository.findById(id)
                   .orElseThrow(()->new ResourceNotFoundException("Employee not found" , id));
          return EmployeeDto.employeeDto(employee);
       }catch (GenerateException e) {
           throw new GenerateException("Error when retrieve employee :" + e.getMessage(), e);
       }

    }

    @Override
    public List<EmployeeDto> getEmployeesByMultipleCriteria(String fullName, String email, String jobTitle, Date hireDate) throws GenerateException {
        try {
            Specification<Employee> specification = Specification.where(null);
            if (fullName != null) {
                specification  = specification.and((root, criteriaQuery, criteriaBuilder)
                ->criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%"+fullName.toLowerCase()+"%"));
            }
            if (email != null) {
                specification = specification.and((root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%"+email.toLowerCase()+"%"));
            }
            if (jobTitle != null) {
                specification = specification.and((root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.lower(root.get("jobTitle")), "%"+jobTitle.toLowerCase()+"%") );
            }
            if (hireDate != null) {
                specification = specification.and((root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("hireDate"), hireDate) );
            }

            List<Employee> employees =  employeeRepository.findAll(specification);

            return employees.stream()
                    .map(EmployeeDto::employeeDto)
                    .collect(Collectors.toList());
        } catch (GenerateException e) {
            throw new GenerateException("Error when retrieve employees :"+e.getMessage(), e);
        }

    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable page)throws GenerateException {
        try {
            Page<Employee> employeePage = employeeRepository.findAll(page);
            return employeePage.map(EmployeeDto::employeeDto);
        } catch (GenerateException e) {
            throw new GenerateException("Error retrieving employees", e);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found" , id));
        employeeRepository.delete(employee);
    }

}
