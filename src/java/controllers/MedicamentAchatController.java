package controllers;

import entities.Medicament;
import entities.MedicamentClient;
import entities.Client;
import entities.Client;
import entities.Medicament;
import entities.MedicamentClient;
import services.MedicamentService;
import services.MedicamentClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/MedicamentAchatController")
public class MedicamentAchatController extends HttpServlet {

    private MedicamentService medicamentService;
    private MedicamentClientService medicamentClientService;

    @Override
    public void init() throws ServletException {
        medicamentService = new MedicamentService();
        medicamentClientService = new MedicamentClientService();
    }

    // Méthode doGet pour afficher la liste des médicaments
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des médicaments et ajouter à la requête
        request.setAttribute("listeMedicaments", medicamentService.findAll());

        // Récupérer un message de la session si présent
        HttpSession session = request.getSession();
        String message = (String) session.getAttribute("message");
        if (message != null) {
            request.setAttribute("message", message);
            session.removeAttribute("message"); // Supprimer le message de la session après l'avoir affiché
        }

        // Rediriger vers la page JSP
        request.getRequestDispatcher("acheterMedicaments.jsp").forward(request, response);
    }

    // Méthode doPost pour gérer l'achat de médicaments
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les paramètres de la requête
            int medicamentId = Integer.parseInt(request.getParameter("medicamentId"));
            int quantiteAchetee = Integer.parseInt(request.getParameter("quantite"));

            // Récupérer le client depuis la session
            HttpSession session = request.getSession();
            Client client = (Client) session.getAttribute("client");

            // Récupérer le médicament sélectionné
            Medicament medicament = medicamentService.findById(medicamentId);

            // Vérifier la quantité disponible et effectuer l'achat
            if (medicament != null && medicament.getQuantite() >= quantiteAchetee) {
                // Mettre à jour la quantité de médicament
                medicament.setQuantite(medicament.getQuantite() - quantiteAchetee);
                medicamentService.update(medicament);

                // Créer une nouvelle entrée pour l'achat dans MedicamentClient
                MedicamentClient mc = new MedicamentClient();
                mc.setClient(client);
                mc.setMedicament(medicament);
                mc.setQuantite(quantiteAchetee);
                mc.setDateAchat(new Date());

                // Sauvegarder l'achat
                medicamentClientService.create(mc);

                // Ajouter un message de succès dans la session
                session.setAttribute("message", "Achat effectué avec succès.");
            } else {
                // Ajouter un message d'erreur dans la session
                session.setAttribute("message", "Quantité insuffisante ou médicament introuvable.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, ajouter un message d'erreur
            HttpSession session = request.getSession();
            session.setAttribute("message", "Erreur lors de l'achat.");
        }

        // Rediriger vers la page d'affichage des médicaments après l'achat
        response.sendRedirect("MedicamentAchatController");
    }
}
