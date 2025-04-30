package controllers;

import com.google.gson.Gson;
import dao.MedicamentDao;
import mapper.MedicamentStockCount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/medicamentQuantite")
public class MedicamentQuantite extends HttpServlet {

    private MedicamentDao medicamentDao = new MedicamentDao();  // Utilisation du DAO pour interagir avec la base de données

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données des médicaments avec leurs quantités depuis la base de données
        List<MedicamentStockCount> medicaments = medicamentDao.countStockPerMedicament();

        // Convertir la liste en JSON
        String jsonResponse = new Gson().toJson(medicaments);

        // Configurer la réponse HTTP en JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Envoyer la réponse
        response.getWriter().write(jsonResponse);
    }
}
