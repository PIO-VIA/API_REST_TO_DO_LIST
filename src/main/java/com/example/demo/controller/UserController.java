package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Créer un utilisateur
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //  Lire (récupérer) tous les utilisateurs
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUserDTOs();
    }

    //  Lire (récupérer) un utilisateur par son id
    @GetMapping("/{id}")
    public List<UserDTO> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
