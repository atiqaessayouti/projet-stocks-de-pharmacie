# Projet de Gestion de Stock

## 1. Contexte 📦
Ce projet vise à créer un système de gestion de stock pour suivre les produits, leurs catégories et les mouvements d'entrée et de sortie. Il est destiné aux commerçants ou entreprises souhaitant gérer efficacement leur inventaire via une interface web moderne.

## 2. Problématique ❗
La gestion manuelle des stocks entraîne des erreurs fréquentes, un manque de traçabilité et une visibilité limitée sur les quantités disponibles. Pour remédier à cela, il est essentiel d'automatiser et de centraliser la gestion des produits et de leurs mouvements.

## 3. Objectifs 🎯
- Gérer les produits, les catégories, les utilisateurs et les mouvements de stock.
- Afficher les produits par catégorie et les détails de chaque fiche produit.
- Ajouter facilement des mouvements (entrée/sortie) avec mise à jour dynamique des quantités via AJAX.
- Visualiser l'évolution du stock à l'aide de graphiques générés avec Chart.js.
- Offrir une interface simple pour un suivi fluide et précis.

## 4. Technologies Utilisées 🧰

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
![Diagramme](https://github.com/user-attachments/assets/f9fa6169-989f-453b-b021-1c48565148d7)




## Version: Système de Gestion des Stocks de Pharmacie

### Classes
- **Medicament** : `nom`, `quantite`, `datePeremption`
- **Fournisseur** : `nom`, `contact`
- **Approvisionnement** : `medicament : Medicament`, `fournisseur : Fournisseur`, `quantite`, `date`
- **User** : `nom`, `email`, `motDePasse`

### Pages
1. **Liste des Médicaments** 📋
2. **Entrées de Stock** ➕
3. **Alertes sur les Stocks Faibles** ⚠️
4. **Statistiques** 📊 : Stock par médicament (Chart.js)

---

N'hésitez pas à demander si vous avez besoin d'aide supplémentaire sur un aspect particulier du projet !
