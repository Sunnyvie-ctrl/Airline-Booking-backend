package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.UserDTO;
import com.KORNN.airline_backend.model.User;
import com.KORNN.airline_backend.service.UserService;

/**
 * REST controller for User management.
 *
 * Responsibilities:
 * - Expose CRUD operations for users
 * - Accepts and returns DTOs for decoupling from the database model
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    
    /**
     * Constructor injection for UserService.
     *
     * @param userService service handling user business logic
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param userDTO user data
     * @return created user
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO.toEntity());
        return ResponseEntity.ok(UserDTO.fromEntity(user));
    }

    /**
     * Retrieves all users.
     *
     * @return list of users
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers()
                .stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
 
    /**
     * Retrieves user by ID.
     *
     * @return user
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserDTO.fromEntity(user));
    }

    /**
     * Updates an existing user.
     *
     * @param id user ID
     * @param userDTO updated data
     * @return updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @RequestBody UserDTO userDTO) {
        User updated = userService.updateUser(id, userDTO.toEntity());
        return ResponseEntity.ok(UserDTO.fromEntity(updated));
    }

    /**
     * Deletes a user by ID.
     *
     * @param id user ID
     * @return empty response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
