package com.KORNN.airline_backend.dto;

import com.KORNN.airline_backend.model.Employee;

/**
 * DTO for Employee entity.
 * Used for employee CRUD operations.
 */
public class EmployeeDTO {

    private Long employeeId;
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private String email;
    private String phoneNumber;
    private Long userId;

    // Constructors
    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeNumber, String firstName, String lastName,
                       String position, String department, String email, String phoneNumber, Long userId) {
        this.employeeId = employeeId;
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    /**
     * Converts Employee entity to EmployeeDTO.
     *
     * @param employee the employee entity
     * @return EmployeeDTO representation
     */
    public static EmployeeDTO fromEntity(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setEmployeeNumber(employee.getEmployeeNumber());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPosition(employee.getPosition());
        dto.setDepartment(employee.getDepartment());
        dto.setEmail(employee.getEmail());
        dto.setPhoneNumber(employee.getPhoneNumber());
        if (employee.getUser() != null) {
            dto.setUserId(employee.getUser().getUserId());
        }
        return dto;
    }

    /**
     * Converts EmployeeDTO to Employee entity.
     *
     * @return Employee entity
     */
    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setEmployeeId(this.employeeId);
        employee.setEmployeeNumber(this.employeeNumber);
        employee.setFirstName(this.firstName);
        employee.setLastName(this.lastName);
        employee.setPosition(this.position);
        employee.setDepartment(this.department);
        employee.setEmail(this.email);
        employee.setPhoneNumber(this.phoneNumber);
        return employee;
    }

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userId=" + userId +
                '}';
    }
}