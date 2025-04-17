/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDao;
import entities.User;
import java.util.List;

/**
 *
 * @author HP
 */
public class TestfinbyEmail {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        String emailRecherche = "alice@example.com";  // 🟡 Remplace par un email existant dans ta base

        List<User> users = userDao.findByEmail(emailRecherche);

        if (users != null && !users.isEmpty()) {
            System.out.println("Utilisateurs avec l'email : " + emailRecherche);
            for (User user : users) {
                System.out.println("Nom : " + user.getNom() + ", Prénom : "  + ", Email : " + user.getEmail());
            }
        } else {
            System.out.println("Aucun utilisateur trouvé avec l'email : " + emailRecherche);
        }
    }
}
