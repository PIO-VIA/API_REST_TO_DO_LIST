# 📝 ToDo List API - Spring Boot

Une API REST construite avec Spring Boot permettant à plusieurs utilisateurs de gérer leurs propres listes de tâches (To-Do). Chaque utilisateur peut s'enregistrer, se connecter et gérer uniquement ses propres tâches.

## 🚀 Fonctionnalités

- Enregistrement des utilisateurs
- Authentification via HTTP Basic Auth
- CRUD complet pour les tâches
- Base de données MySQL
- Architecture claire : Controller - Service - Repository - Entity

---

## 🛠️ Stack technique

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Lombok
- Postman (pour les tests)

---

## 📁 Structure du projet

```bash

src/
├── controller/         # Contrôleurs REST
├── model/              # Entités JPA
├── repository/         # Interfaces de persistance
├── service/            # Logique métier
├── security/           # Configuration Spring Security
└── ClassopenApplication.java
```
---
## Comment Utiliser ?
- cloner le projet 
```bash

git clone https://github.com/PIO-VIA/API_REST_TO_DO_LIST.git
```
- Ouvrer le projet dans votre éditeur de code (ex: Intellij Idea)
- Lancer la classe `ClassopenApplication.java`
- Ouvrer Postman et créer une collection d'une API REST avec pour base_url: http://localhost:9000
- Maintenant, vous pouvez faire les requètes `htpp( GET, POST,PUT, DELETE)`
---
## Auteur
Ce projet est fait par moi **PIO VIANNEY** dans  le cadre de l'apprentissage de Spring Boot. 