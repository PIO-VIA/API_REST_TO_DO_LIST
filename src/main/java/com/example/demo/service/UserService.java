package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //  Créer un utilisateur
    public User createUser(User user) {
        user.setUserUuid(String.valueOf(UUID.randomUUID()));
        return userRepository.save(user);
    }

    // Récupérer tous les utilisateurs
    public List<UserDTO> getAllUserDTOs() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getUserUuid(), user.getUsername()))
                .collect(Collectors.toList());
    }

    //  Récupérer un utilisateur par ID
    public List<UserDTO> getUserById(String id) {
        return userRepository.findByUserUuid(id)
                .stream()
                .map(user -> new UserDTO(user.getUserUuid(), user.getUsername()))
                .collect(Collectors.toList());
    }
    //  Mettre à jour un utilisateur
    public User updateUser(Long id, User updatedUser) {
        User existingUser =  userRepository.getReferenceById(id);
        if(existingUser!=null){
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        }
        throw new RuntimeException("Utilisateur non trouvé avec l'id : " + id);
    }

    //  Supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
