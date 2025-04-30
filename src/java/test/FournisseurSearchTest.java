package test;

import dao.FournisseurtDao;
import entities.Fournisseur;
import util.HibernateUtil;

import java.util.List;

public class FournisseurSearchTest {
    public static void main(String[] args) {
        // Initialisation de Hibernate
        HibernateUtil.getSessionFactory();

        // Création d'une instance du DAO
        FournisseurtDao fournisseurDao = new FournisseurtDao();

        // Nom du fournisseur à rechercher
        String nomRecherche = "Fournisseur A";
        
        // Recherche du fournisseur par nom
        List<Fournisseur> fournisseurs = fournisseurDao.findByNom(nomRecherche);

        // Affichage des résultats
        System.out.println("Résultats de la recherche pour le nom '" + nomRecherche + "':");
        if (fournisseurs != null && !fournisseurs.isEmpty()) {
            for (Fournisseur f : fournisseurs) {
                System.out.println(f.getNom() + " - Contact : " + f.getContact());
            }
        } else {
            System.out.println("Aucun fournisseur trouvé avec ce nom.");
        }

        // Fermez la session Hibernate
        HibernateUtil.getSessionFactory().close();
    }
}