package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
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
    @JsonIgnore
    private User user;

}
