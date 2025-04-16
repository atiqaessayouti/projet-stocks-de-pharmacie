package test;

import dao.MedicamentDao;
import entities.Medicament;
import java.util.List;

public class TestFindByQuantite {
    public static void main(String[] args) {
        MedicamentDao md = new MedicamentDao();
        
        int quantityToFind = 100; // Adjust this value based on your test data
        List<Medicament> medicaments = md.findByQuantite(quantityToFind);
        
        if (medicaments == null || medicaments.isEmpty()) {
            System.out.println("No medicaments found with quantity: " + quantityToFind);
        } else {
            for (Medicament m : medicaments) {
                System.out.println("ID: " + m.getId() + ", Nom: " + m.getNom() + 
                                   ", Quantité: " + m.getQuantite() + 
                                   ", Date de péremption: " + m.getDatePeremption());
            }
        }
    }
}