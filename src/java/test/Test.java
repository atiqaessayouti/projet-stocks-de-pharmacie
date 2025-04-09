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
import java.util.List;
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

        // Boucles de filtrage

        // Filtrer et afficher tous les utilisateurs
        System.out.println("Liste des utilisateurs :");
        List<User> users = userDao.findAll(); // Assurez-vous d'avoir une méthode findAll
        for (User u : users) {
            System.out.println(u.getNom() + " - " + u.getEmail());
        }

        // Filtrer et afficher tous les médicaments
        System.out.println("Liste des médicaments :");
        List<Medicament> medicaments = medicamentDao.findAll(); // Assurez-vous d'avoir une méthode findAll
        for (Medicament m : medicaments) {
            System.out.println(m.getNom() + " - Quantité : " + m.getQuantite());
        }

        // Filtrer et afficher tous les fournisseurs
        System.out.println("Liste des fournisseurs :");
        List<Fournisseur> fournisseurs = fournisseurDao.findAll(); // Assurez-vous d'avoir une méthode findAll
        for (Fournisseur f : fournisseurs) {
            System.out.println(f.getNom() + " - Contact : " + f.getContact());
        }

        // Filtrer et afficher tous les clients
        System.out.println("Liste des clients :");
        List<Client> clients = clientDao.findAll(); // Assurez-vous d'avoir une méthode findAll
        for (Client c : clients) {
            System.out.println(c.getNom() + " - Email : " + c.getEmail());
        }

        // Nettoyage
        // Ajoutez ici le code pour supprimer les entités si nécessaire

        // Fermez la session Hibernate
        HibernateUtil.getSessionFactory().close();
    }
}