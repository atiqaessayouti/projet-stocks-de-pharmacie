package controllers;

import entities.Medicament;
import services.MedicamentService;
import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MedicamentController", urlPatterns = {"/MedicamentController"})
public class MedicamentController extends HttpServlet {

    private MedicamentService ms;

    @Override
    public void init() throws ServletException {
        super.init();
        ms = new MedicamentService();
    }

    private void addMedicament(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String datePeremptionStr = request.getParameter("datePeremption");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date datePeremption = sdf.parse(datePeremptionStr);
            Medicament medicament = new Medicament(nom, quantite, datePeremption);
            ms.create(medicament);
            response.sendRedirect("medicaments.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de l'ajout du médicament");
        }
    }

    private void updateMedicament(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String datePeremptionStr = request.getParameter("datePeremption");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date datePeremption = sdf.parse(datePeremptionStr);
            Medicament medicament = new Medicament(nom, quantite, datePeremption);
            medicament.setId(Integer.parseInt(id));
            ms.update(medicament);
            response.sendRedirect("medicaments.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de la mise à jour du médicament");
        }
    }

    private void deleteMedicament(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ms.delete(ms.findById(Integer.parseInt(id)));
        response.sendRedirect("medicaments.jsp");
    }

    private void editMedicament(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Medicament medicament = ms.findById(Integer.parseInt(id));
        request.setAttribute("medicament", medicament);
        request.getRequestDispatcher("medicaments.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op == null) {
            // If no operation is provided, this means we're either adding or updating a medicament
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                addMedicament(request, response); // Handle add
            } else {
                updateMedicament(request, response); // Handle update
            }
        } else {
            // Handle operations like delete and update by op
            switch (op) {
                case "delete":
                    deleteMedicament(request, response);
                    break;
                case "update":
                    editMedicament(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp?error=Opération invalide");
                    break;
            }
        }
    }

    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MedicamentService ms = new MedicamentService();
    String op = request.getParameter("op");

    if (op != null) {
        int id = Integer.parseInt(request.getParameter("id"));

        if (op.equals("delete")) {
            ms.delete(ms.findById(id));
            response.sendRedirect("medicaments.jsp"); // Rediriger après suppression
        } 
        else if (op.equals("update")) {
            Medicament medicament = ms.findById(id);
            List<Medicament> medicaments = ms.findAll();

            request.setAttribute("medicament", medicament); // pour pré-remplir le formulaire
            request.setAttribute("medicaments", medicaments); // afficher la liste aussi

            request.getRequestDispatcher("medicaments.jsp").forward(request, response); // reste sur la même page
        }
    } else {
        response.sendRedirect("medicaments.jsp");
    }
}


    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MedicamentService ms = new MedicamentService();

    String idParam = request.getParameter("id");
    String nom = request.getParameter("nom");
    int quantite = Integer.parseInt(request.getParameter("quantite"));
    Date datePeremption = null;

    try {
        datePeremption = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datePeremption"));
    } catch (ParseException e) {
        e.printStackTrace();
    }

    if (idParam == null || idParam.isEmpty()) {
        // Ajout
        Medicament med = new Medicament(nom, quantite, datePeremption);
        ms.create(med);
    } else {
        // Modification
        int id = Integer.parseInt(idParam);
        Medicament med = ms.findById(id);
        med.setNom(nom);
        med.setQuantite(quantite);
        med.setDatePeremption(datePeremption);
        ms.update(med);
    }

    response.sendRedirect("medicaments.jsp");
}


    @Override
    public String getServletInfo() {
        return "Medicament Controller Servlet";
    }
}
