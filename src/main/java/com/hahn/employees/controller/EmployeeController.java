package com.hahn.employees.controller;
import com.hahn.employees.dto.EmployeeDto;
import com.hahn.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final PagedResourcesAssembler<EmployeeDto> resourcesAssembler;
    @Autowired
    public EmployeeController(EmployeeService employeeService, PagedResourcesAssembler<EmployeeDto> resourcesAssembler) {
        this.employeeService = employeeService;
        this.resourcesAssembler = resourcesAssembler;
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    //GET /employees?fullName=John&email=john.doe@example.com&jobTitle=Developer&hireDate=2024-01-15
    @GetMapping
    public List<EmployeeDto> getEmployeesByMultipleCriteria(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hireDate){

        return employeeService.getEmployeesByMultipleCriteria(fullName, email, jobTitle, hireDate);
    }

    @GetMapping("/all")
    public Page<EmployeeDto> getAllEmployees(Pageable page) {
        return employeeService.getAllEmployees(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
