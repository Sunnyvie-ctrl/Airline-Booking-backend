package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.User;
import fr.epita.timeoutairline.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired // injects the userService implementations here
    private UserService userService;

    // CREATE - POST /api/v1/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // READ ALL - GET /api/v1/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // READ ONE - GET /api/v1/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - PUT /api/v1/users/{id}
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}