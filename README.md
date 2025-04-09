Projet de Gestion de Stock
1. Contexte 📦
Ce projet vise à créer un système de gestion de stock pour suivre les produits, leurs catégories et les mouvements d'entrée et de sortie. Il est destiné aux commerçants ou entreprises souhaitant gérer efficacement leur inventaire via une interface web moderne.

2. Problématique ❗
La gestion manuelle des stocks entraîne des erreurs fréquentes, un manque de traçabilité et une visibilité limitée sur les quantités disponibles. Pour remédier à cela, il est essentiel d'automatiser et de centraliser la gestion des produits et de leurs mouvements.

3. Objectifs 🎯
Gérer les produits, les catégories, les utilisateurs et les mouvements de stock.
Afficher les produits par catégorie et les détails de chaque fiche produit.
Ajouter facilement des mouvements (entrée/sortie) avec mise à jour dynamique des quantités via AJAX.
Visualiser l'évolution du stock à l'aide de graphiques générés avec Chart.js.
Offrir une interface simple pour un suivi fluide et précis.
4. Technologies Utilisées 🧰
Frontend
HTML5 : Structure des pages.
CSS3 : Mise en forme et style.
JavaScript : Logique côté client et interactions dynamiques.
AJAX : Communication asynchrone avec le serveur.
Chart.js : Affichage de graphiques statistiques.
Backend
Java : Langage principal pour la logique métier.
Hibernate : Gestion de la persistance des données.
JPA : Interface standard pour travailler avec Hibernate.
JDBC : Utilisé pour des requêtes spécifiques.
Base de Données
MySQL : Système de gestion de base de données relationnelle.
5. Diagramme de Classe 🗂️
![Diagramme](https://github.com/user-attachments/assets/95c6d1b9-2b5c-4a7b-a448-3eebe9644702)


6. Modèle Conceptuel de la Base 🗺️
![conception](https://github.com/user-attachments/assets/05a64118-6429-4291-963c-20bc2f6f5c5b)


7. Exécution des Tests dans la Console 🧪
![term1](https://github.com/user-attachments/assets/7e0561b1-4c40-42e9-a6ff-ca150abff0a3)

![term2](https://github.com/user-attachments/assets/81b8c2ba-9dd9-47e7-a834-44ebefc1e904)
![term3](https://github.com/user-attachments/assets/1f373526-bc1e-4d2c-ba8c-befc99f1ceff)

Version: Système de Gestion des Stocks de Pharmacie
Classes
Medicament : nom, quantite, datePeremption
Fournisseur : nom, contact
Approvisionnement : medicament : Medicament, fournisseur : Fournisseur, quantite, date
User : nom, email, motDePasse
