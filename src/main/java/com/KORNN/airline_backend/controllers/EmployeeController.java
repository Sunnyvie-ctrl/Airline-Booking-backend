package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.EmployeeDTO;
import com.KORNN.airline_backend.model.Employee;
import com.KORNN.airline_backend.service.EmployeeService;

/**
 * REST controller for Employee management.
 *
 * Responsibilities:
 * - CRUD operations
 * - Employees linked to Users
 * - Uses DTOs for input/output
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<EmployeeDTO> createEmployee(@PathVariable Long userId,
                                                      @RequestBody EmployeeDTO dto) {
        Employee employee = employeeService.createEmployee(userId, dto.toEntity());
        return ResponseEntity.ok(EmployeeDTO.fromEntity(employee));
    }

    @GetMapping("/{numEmp}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String numEmp) {
        Employee emp = employeeService.getEmployee(numEmp);
        return ResponseEntity.ok(EmployeeDTO.fromEntity(emp));
    }

    @PutMapping("/{numEmp}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String numEmp,
                                                      @RequestBody EmployeeDTO dto) {
        Employee updated = employeeService.updateEmployee(numEmp, dto.toEntity());
        return ResponseEntity.ok(EmployeeDTO.fromEntity(updated));
    }

    @DeleteMapping("/{numEmp}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String numEmp) {
        employeeService.deleteEmployee(numEmp);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
}
