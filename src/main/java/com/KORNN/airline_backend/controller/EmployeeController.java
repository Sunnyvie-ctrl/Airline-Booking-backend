package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.Employee;
import fr.epita.timeoutairline.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE - POST /api/v1/employees
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // READ ALL - GET /api/v1/employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // READ ONE - GET /api/v1/employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // READ BY EMPLOYEE NUMBER - GET /api/v1/employees/emp/{numEmp}
    @GetMapping("/emp/{numEmp}")
    public ResponseEntity<Employee> getEmployeeByNumEmp(@PathVariable String numEmp) {
        return employeeService.getEmployeeByNumEmp(numEmp)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - PUT /api/v1/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}