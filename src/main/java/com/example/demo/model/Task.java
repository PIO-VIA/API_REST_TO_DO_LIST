package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //Génère automatiquement getters, setters, toString, equals, hashCode
@NoArgsConstructor //Génère un constructeur vide
@AllArgsConstructor //Génère un constructeur avec tous les attributs
@Builder //Permet de créer facilement un objet Task avec .builder()
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le titre ne doit pas être vide")
    private String title;
    private String description;
    private boolean completed;
    @ManyToOne(fetch = FetchType.LAZY)  // Association avec l'utilisateur
    @JoinColumn(name = "user_id")       // Colonne pour la relation
    private User user;

}
