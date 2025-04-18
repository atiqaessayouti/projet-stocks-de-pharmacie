/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDao;
import entities.User;

/**
 *
 * @author hp
 */
public class TestLogin {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        String email = "HH@example.com"; // Assurez-vous que cet utilisateur existe
        String motDePasse = "HH";  // Assurez-vous que cela correspond au mot de passe exact

        User user = userDao.findByEmailAndPassword(email, motDePasse);
        
        if (user != null) {
            System.out.println("Connexion réussie ! Bienvenue " + user.getNom());
        } else {
            System.out.println("Echec de la connexion. Email ou mot de passe incorrect.");
        }
    }  
}
