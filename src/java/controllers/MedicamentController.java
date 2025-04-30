package controllers;

import com.google.gson.Gson;
import entities.Medicament;
import services.MedicamentService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapper.MedicamentStockCount;

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
        String categorie = request.getParameter("categorie");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String datePeremptionStr = request.getParameter("datePeremption");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date datePeremption = sdf.parse(datePeremptionStr);
            Medicament medicament = new Medicament(nom, categorie, quantite, datePeremption);
            ms.create(medicament);
            response.sendRedirect("medicaments.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de l'ajout du médicament");
        }
    }

    private void updateMedicament(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String categorie = request.getParameter("categorie");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String datePeremptionStr = request.getParameter("datePeremption");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date datePeremption = sdf.parse(datePeremptionStr);
            Medicament medicament = ms.findById(Integer.parseInt(id));
            if (medicament != null) {
                medicament.setNom(nom);
                medicament.setCategorie(categorie);
                medicament.setQuantite(quantite);
                medicament.setDatePeremption(datePeremption);
                ms.update(medicament);
            }
            response.sendRedirect("medicaments.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=Erreur lors de la mise à jour du médicament");
        }
    }

    private void deleteMedicament(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Medicament medicament = ms.findById(Integer.parseInt(id));
        if (medicament != null) {
            ms.delete(medicament);
        }
        response.sendRedirect("medicaments.jsp");
    }

    private void editMedicament(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Medicament medicament = ms.findById(Integer.parseInt(id));
        List<Medicament> medicaments = ms.findAll();

        request.setAttribute("medicament", medicament); // Pré-remplir formulaire
        request.setAttribute("medicaments", medicaments); // afficher tous les médicaments
        request.getRequestDispatcher("medicaments.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op == null) {
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                addMedicament(request, response);
            } else {
                updateMedicament(request, response);
            }
        } else {
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

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    // Récupérer la liste des stocks de médicaments
    List<MedicamentStockCount> stockCounts = ms.countStockPerMedicament();
    
    // Vérifier si la liste est vide
    if (stockCounts.isEmpty()) {
        System.out.println("Aucun médicament trouvé dans le stock");
    }
    
    // Convertir la liste en JSON
    Gson gson = new Gson();
    String json = gson.toJson(stockCounts);

    // Renvoyer le JSON au front-end
    response.setContentType("application/json");
    response.getWriter().write(json);
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Medicament Controller Servlet";
    }
   

}
