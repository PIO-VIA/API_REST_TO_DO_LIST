package com.example.demo.repository;


import com.example.demo.model.Task;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    /*
    Ici, tu peux deja faire les méthodes suivantes sans écrire du code :
    save(entity) => enregistrer une entité,

    findById(id) => récupérer une entité par son ID,

    findAll() => récupérer toutes les entités,

    delete(entity) => supprimer une entité.
    Tu peux ajouter ici des méthodes personnalisées si besoin plus tard*/
}
