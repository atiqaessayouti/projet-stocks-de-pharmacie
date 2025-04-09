package test;

import dao.UserDao;
import dao.MedicamentDao;
import dao.ClientDAO;
import dao.ApprovisionnementDao;
import dao.FournisseurtDao; // Assurez-vous d'importer le DAO pour Fournisseur
import entities.User;
import entities.Medicament;
import entities.Client;
import entities.Approvisionnement;
import entities.Fournisseur; // Importation de l'entité Fournisseur
import java.util.Date;
import util.HibernateUtil;

public class Test {

    public static void main(String[] args) {
        // Initialisation de Hibernate
        HibernateUtil.getSessionFactory();

        // Test UserDao
        UserDao userDao = new UserDao();
        User user = new User("Alice", "alice@example.com", "securePassword");
        userDao.create(user);
        System.out.println("Utilisateur créé : " + user.getNom());

        // Test MedicamentDao
        MedicamentDao medicamentDao = new MedicamentDao();
        Medicament medicament = new Medicament("Paracetamol", 100, new Date());
        medicamentDao.create(medicament);
        System.out.println("Médicament créé : " + medicament.getNom());

        // Test FournisseurDao
        FournisseurtDao fournisseurDao = new FournisseurtDao(); // Créez un DAO pour Fournisseur
        Fournisseur fournisseur = new Fournisseur("Fournisseur A", "contact@fournisseur.com");
        fournisseurDao.create(fournisseur);
        System.out.println("Fournisseur créé : " + fournisseur.getNom());

        // Test ClientDAO
        ClientDAO clientDao = new ClientDAO();
        Client client = new Client("Bob", "bob@example.com", "securePassword");
        clientDao.create(client);
        System.out.println("Client créé : " + client.getNom());

        // Test ApprovisionnementDao
        ApprovisionnementDao approvisionnementDao = new ApprovisionnementDao();
        Approvisionnement approvisionnement = new Approvisionnement(new Date(), medicament, fournisseur); // Passer le fournisseur ici
        approvisionnementDao.create(approvisionnement);
        System.out.println("Approvisionnement créé pour le médicament : " + medicament.getNom());

        // Nettoyage
    }
}