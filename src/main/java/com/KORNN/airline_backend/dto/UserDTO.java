package com.KORNN.airline_backend.dto;

import com.KORNN.airline_backend.model.User;

/**
 * DTO for User entity.
 * Used for user CRUD operations.
 */
public class UserDTO {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private String role;
    private Boolean active;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(Long userId, String username, String password, String email, String role, Boolean active) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    /**
     * Converts User entity to UserDTO.
     *
     * @param user the user entity
     * @return UserDTO representation
     */
    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        // Note: Password should NOT be included in responses for security
        // dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setActive(user.getActive());
        return dto;
    }

    /**
     * Converts UserDTO to User entity.
     *
     * @return User entity
     */
    public User toEntity() {
        User user = new User();
        user.setUserId(this.userId);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setRole(this.role);
        user.setActive(this.active);
        return user;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }
}
