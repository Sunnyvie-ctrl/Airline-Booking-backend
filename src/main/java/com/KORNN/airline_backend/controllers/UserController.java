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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO.toEntity());
        return ResponseEntity.ok(UserDTO.fromEntity(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers()
                .stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserDTO.fromEntity(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @RequestBody UserDTO userDTO) {
        User updated = userService.updateUser(id, userDTO.toEntity());
        return ResponseEntity.ok(UserDTO.fromEntity(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
