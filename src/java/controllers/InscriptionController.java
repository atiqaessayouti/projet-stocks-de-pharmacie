/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ClientService;

/**
 *
 * @author HP
 */
@WebServlet("/InscriptionController")
public class InscriptionController extends HttpServlet {
    private ClientService clientService = new ClientService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");

        Client client = new Client(nom, email, motdepasse);
        clientService.create(client);  // Stocker en base

        // Passer le message de succès à la JSP
        request.setAttribute("messageSucces", "Bienvenue " + nom + " ! Votre inscription a été effectuée avec succès.");
        request.getRequestDispatcher("client_dashboard.jsp").forward(request, response);
    }
}

