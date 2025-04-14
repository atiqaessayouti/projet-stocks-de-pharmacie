# Projet de Gestion de Stock

## Contexte 📦
Ce projet vise à créer un système de gestion de stock pour suivre les produits, leurs catégories et les mouvements d'entrée et de sortie. Il est destiné aux commerçants ou entreprises souhaitant gérer efficacement leur inventaire via une interface web moderne.

## Problématique ❗
La gestion manuelle des stocks entraîne des erreurs fréquentes, un manque de traçabilité et une visibilité limitée sur les quantités disponibles. Pour remédier à cela, il est essentiel d'automatiser et de centraliser la gestion des produits et de leurs mouvements.

## Objectifs 🎯
- Gérer les produits, les catégories, les utilisateurs et les mouvements de stock.
- Afficher les produits par catégorie et les détails de chaque fiche produit.
- Ajouter facilement des mouvements (entrée/sortie) avec mise à jour dynamique des quantités via AJAX.
- Visualiser l'évolution du stock à l'aide de graphiques générés avec Chart.js.
- Offrir une interface simple pour un suivi fluide et précis.

## Technologies Utilisées 🧰

### Frontend
- **HTML5** : Structure des pages.
- **CSS3** : Mise en forme et style.
- **JavaScript** : Logique côté client et interactions dynamiques.
- **AJAX** : Communication asynchrone avec le serveur.
- **Chart.js** : Affichage de graphiques statistiques.

### Backend
- **Java** : Langage principal pour la logique métier.
- **Hibernate** : Gestion de la persistance des données.
- **JPA** : Interface standard pour travailler avec Hibernate.
- **JDBC** : Utilisé pour des requêtes spécifiques.

### Base de Données
- **MySQL** : Système de gestion de base de données relationnelle.

## 5. Diagramme de Classe 🗂️
![Diagramme](https://github.com/user-attachments/assets/c0da52a8-2f8e-42e5-9673-e8560c2ec9ca)


## 6. Modèle Conceptuel de la Base 🗺️

![conspution](https://github.com/user-attachments/assets/6b6fb94d-8da2-40cc-9704-8dbdac98c640)


## 7. Exécution des Tests dans la Console 🧪

![term1](https://github.com/user-attachments/assets/77c0eb52-a566-4b2b-a283-b083c66d3151)

![term2](https://github.com/user-attachments/assets/32deffaa-d7dd-427a-bd5f-523a9b55c382)

![term3](https://github.com/user-attachments/assets/0a880126-45e8-4fda-81cd-20c6a3a02b9c)

## 7. Exécution des Filtrages dans la Console 🧪
![filtrrage](https://github.com/user-attachments/assets/29e8202a-c7ed-49a9-81e4-1470f859a0a9)

![fil3](https://github.com/user-attachments/assets/649d380a-5e32-49d5-98a7-0abd257fef3d)

![fil4](https://github.com/user-attachments/assets/bcb3b943-6f42-461f-99af-7fcb76f15891)


![fil5](https://github.com/user-attachments/assets/09cdd157-2a7d-4636-8e99-e3cfd25c916b)


## Version : Système de Gestion des Stocks de Pharmacie

### Classes
- **Medicament** : `nom`, `quantite`, `datePeremption`
- **Fournisseur** : `nom`, `contact`
- **Approvisionnement** : `medicament : Medicament`, `fournisseur : Fournisseur`, `quantite`, `date`
- **User** : `nom`, `email`, `motDePasse`
- **Client** :`nom`, `email`, `motDePasse`
- **admin** : `nom`, `email`, `motDePasse`
-**MedicamentClient** : `dateAchat`

---
