package controllers;

import entities.Client;
import services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ClientController")
public class ClientController extends HttpServlet {

    private final ClientService clientService = new ClientService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("clients.jsp");
            return;
        }

        switch (action) {
            case "create":
                createClient(request);
                break;
            case "update":
                updateClient(request);
                break;
            case "delete":
                deleteClient(request);
                break;
        }

        response.sendRedirect("clients.jsp");
    }

    private void createClient(HttpServletRequest request) {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        Client client = new Client(nom, email, motDePasse);
        clientService.create(client);
    }

    private void updateClient(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        Client existingClient = clientService.findById(id);
        if (existingClient != null) {
            existingClient.setNom(nom);
            existingClient.setEmail(email);
            existingClient.setMotDePasse(motDePasse);
            clientService.update(existingClient);
        }
    }

    private void deleteClient(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = clientService.findById(id);
        if (client != null) {
            clientService.delete(client);
        }
    }
}
