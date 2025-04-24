package test;

import dao.MedicamentDao;
import entities.Medicament;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestMedicament {
    public static void main(String[] args) {
        MedicamentDao md = new MedicamentDao();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2025-01-01");
            Date endDate = sdf.parse("2025-04-16");

            List<Medicament> medicaments = md.findBetweenDate(startDate, endDate);
            for (Medicament m : medicaments) {
                System.out.println("Nom: " + m.getNom() + ", Quantité: " + m.getQuantite() + ", Date de péremption: " + m.getDatePeremption());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log any exceptions
        }
    }
}