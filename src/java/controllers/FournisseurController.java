package controllers;

import entities.Fournisseur;
import services.FournisseurService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FournisseurController", urlPatterns = {"/FournisseurController"})
public class FournisseurController extends HttpServlet {

    private FournisseurService fs;

    @Override
    public void init() throws ServletException {
        super.init();
        fs = new FournisseurService();
    }

    private void addFournisseur(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String contact = request.getParameter("contact");

        try {
            Fournisseur fournisseur = new Fournisseur(nom, contact);
            fs.create(fournisseur);
            response.sendRedirect("fournisseurs.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de l'ajout du fournisseur");
        }
    }

    private void updateFournisseur(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String contact = request.getParameter("contact");

        try {
            Fournisseur fournisseur = new Fournisseur(nom, contact);
            fournisseur.setId(Integer.parseInt(id));
            fs.update(fournisseur);
            response.sendRedirect("fournisseurs.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de la mise à jour du fournisseur");
        }
    }

    private void deleteFournisseur(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        fs.delete(fs.findById(Integer.parseInt(id)));
        response.sendRedirect("fournisseurs.jsp");
    }

    private void editFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Fournisseur fournisseur = fs.findById(Integer.parseInt(id));
        request.setAttribute("fournisseur", fournisseur);
        request.getRequestDispatcher("fournisseurs.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op == null) {
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                addFournisseur(request, response); 
            } else {
                updateFournisseur(request, response); 
            }
        } else {
            switch (op) {
                case "delete":
                    deleteFournisseur(request, response);
                    break;
                case "update":
                    editFournisseur(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp?error=Opération invalide");
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op != null) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (op.equals("delete")) {
                fs.delete(fs.findById(id));
                response.sendRedirect("fournisseurs.jsp");
            } 
            else if (op.equals("update")) {
                Fournisseur fournisseur = fs.findById(id);
                request.setAttribute("fournisseur", fournisseur);
                request.getRequestDispatcher("fournisseurs.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("fournisseurs.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String nom = request.getParameter("nom");
        String contact = request.getParameter("contact");

        if (idParam == null || idParam.isEmpty()) {
            Fournisseur fournisseur = new Fournisseur(nom, contact);
            fs.create(fournisseur);
        } else {
            int id = Integer.parseInt(idParam);
            Fournisseur fournisseur = fs.findById(id);
            fournisseur.setNom(nom);
            fournisseur.setContact(contact);
            fs.update(fournisseur);
        }

        response.sendRedirect("fournisseurs.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Fournisseur Controller Servlet";
    }
}
