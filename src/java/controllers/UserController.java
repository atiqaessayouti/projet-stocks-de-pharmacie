/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.Admin;
import entities.Client;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;


 
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {
    private UserService us;

    @Override
    public void init() throws ServletException {
        super.init();
        us = new UserService(); // Initialisation du service des utilisateurs
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");

        if (op == null) {
            // Formulaire de création et mise à jour des utilisateurs
        } else if (op.equals("login")) {
            // Logique pour la connexion d'un utilisateur
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("mdp");

            // Récupérer l'utilisateur par son email
            List<User> users = us.findByEmail(email);
            if (users != null && !users.isEmpty()) {
                User user = users.get(0); // On prend le premier utilisateur trouvé
                if (user.getMotDePasse().equals(motDePasse)) {
                    // Si l'email et le mot de passe sont corrects, vérifier le type d'utilisateur
                    if (user instanceof Admin) {
                        // Si c'est un Admin, rediriger vers le tableau de bord de l'admin
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("dashboard.jsp");
                    } else if (user instanceof Client) {
                        // Si c'est un Client, rediriger vers le tableau de bord du client
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("client_dashboard.jsp");
                    }
                } else {
                    // Mot de passe incorrect, rediriger vers la page de connexion avec un message d'erreur
                    response.sendRedirect("login.jsp?error=true");
                }
            } else {
                // Si aucun utilisateur n'est trouvé avec cet email, rediriger vers la page de connexion
                response.sendRedirect("login.jsp?error=true");
            }
        } else if (op.equals("delete")) {
            // Logique pour supprimer un utilisateur
            String id = request.getParameter("id");
            if (id != null && !id.isEmpty()) {
                us.delete(us.findById(Integer.parseInt(id)));
                response.sendRedirect("users/users.jsp"); // Rediriger vers la liste des utilisateurs
            } else {
                response.sendRedirect("error.jsp"); // En cas d'erreur de suppression
            }
        } else if (op.equals("update")) {
            // Logique pour mettre à jour un utilisateur
            String id = request.getParameter("id");
            if (id != null && !id.isEmpty()) {
                User u = us.findById(Integer.parseInt(id));
                if (u != null) {
                    request.setAttribute("user", u);
                    request.getRequestDispatcher("user_form.jsp").forward(request, response);
                } else {
                    response.sendRedirect("users/users.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp"); // Rediriger si l'option est invalide
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Gestion des utilisateurs";
    }
}
