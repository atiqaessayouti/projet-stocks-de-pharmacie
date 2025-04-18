package test;

import dao.AdminDao;
import dao.UserDao;
import dao.MedicamentDao;
import dao.ClientDAO;
import dao.ApprovisionnementDao;
import dao.FournisseurtDao; // Assurez-vous d'importer le DAO pour Fournisseur
import dao.MedicamentClientDao;
import entities.Admin;
import entities.User;
import entities.Medicament;
import entities.Client;
import entities.Approvisionnement;
import entities.Fournisseur; // Importation de l'entité Fournisseur
import entities.MedicamentClient;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Initialisation de Hibernate
        HibernateUtil.getSessionFactory();

        // Test UserDao
        UserDao userDao = new UserDao();
        User user1 = new User("Alice", "alice@example.com", "securePassword");
        User user2 = new User("Bob", "bob@example.com", "securePassword");
        User user3 = new User("Charlie", "charlie@example.com", "securePassword");
        User user4 = new User("HH", "HH@example.com", "HH");
        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);
        userDao.create(user4);
        System.out.println("Utilisateurs créés :");
        System.out.println(user1.getNom() + " - " + user1.getEmail());
        System.out.println(user2.getNom() + " - " + user2.getEmail());
        System.out.println(user3.getNom() + " - " + user3.getEmail());
        System.out.println(user4.getNom() + " - " + user3.getEmail());
        // Test MedicamentDao
        MedicamentDao medicamentDao = new MedicamentDao();
        Medicament medicament1 = new Medicament("Paracetamol", 100, new Date());
        Medicament medicament2 = new Medicament("Ibuprofène", 200, new Date());
        Medicament medicament3 = new Medicament("Aspirine", 150, new Date());
        Medicament medicament4 = new Medicament("Amoxicilline", 50, new Date());
        Medicament medicament5 = new Medicament("Cétirizine", 75, new Date());
        
        medicamentDao.create(medicament1);
        medicamentDao.create(medicament2);
        medicamentDao.create(medicament3);
        medicamentDao.create(medicament4);
        medicamentDao.create(medicament5);
        
        System.out.println("Médicaments créés :");
        System.out.println(medicament1.getNom() + " - Quantité : " + medicament1.getQuantite());
        System.out.println(medicament2.getNom() + " - Quantité : " + medicament2.getQuantite());
        System.out.println(medicament3.getNom() + " - Quantité : " + medicament3.getQuantite());
        System.out.println(medicament4.getNom() + " - Quantité : " + medicament4.getQuantite());
        System.out.println(medicament5.getNom() + " - Quantité : " + medicament5.getQuantite());

        // Test FournisseurDao
        FournisseurtDao fournisseurDao = new FournisseurtDao();
        Fournisseur fournisseur1 = new Fournisseur("Fournisseur A", "contact@fournisseur.com");
        Fournisseur fournisseur2 = new Fournisseur("Fournisseur B", "contactB@fournisseur.com");
        Fournisseur fournisseur3 = new Fournisseur("Fournisseur C", "contactC@fournisseur.com");
        
        fournisseurDao.create(fournisseur1);
        fournisseurDao.create(fournisseur2);
        fournisseurDao.create(fournisseur3);
        
        System.out.println("Fournisseurs créés :");
        System.out.println(fournisseur1.getNom() + " - Contact : " + fournisseur1.getContact());
        System.out.println(fournisseur2.getNom() + " - Contact : " + fournisseur2.getContact());
        System.out.println(fournisseur3.getNom() + " - Contact : " + fournisseur3.getContact());

        // Test ClientDAO
        ClientDAO clientDao = new ClientDAO();
        Client client1 = new Client("Client A", "clientA@example.com", "client123");
        Client client2 = new Client("Client B", "clientB@example.com", "client456");
        
        clientDao.create(client1);
        clientDao.create(client2);
        
        System.out.println("Clients créés :");
        System.out.println(client1.getNom() + " - Email : " + client1.getEmail());
        System.out.println(client2.getNom() + " - Email : " + client2.getEmail());
          // Test AdminDao
        AdminDao adminDao = new AdminDao();
        Admin admin1 = new Admin("SUPER_ADMIN", "Admin A", "adminA@example.com", "securePass");
        Admin admin2 = new Admin("ADMIN", "Admin B", "adminB@example.com", "securePass");
        
        adminDao.create(admin1);
        adminDao.create(admin2);
        
        System.out.println("Administrateurs créés :");
        System.out.println(admin1.getNom() + " - " + admin1.getEmail() + " - Rôle : " + admin1.getRole());
        System.out.println(admin2.getNom() + " - " + admin2.getEmail() + " - Rôle : " + admin2.getRole());

        // Test ApprovisionnementDao
        ApprovisionnementDao approvisionnementDao = new ApprovisionnementDao();
        Approvisionnement approvisionnement = new Approvisionnement(new Date(), medicament1, fournisseur1);
        approvisionnementDao.create(approvisionnement);
        System.out.println("Approvisionnement créé pour le médicament : " + medicament1.getNom());
       // Dans votre classe Test
MedicamentClientDao medicamentClientDao = new MedicamentClientDao();
MedicamentClient medicamentClient = new MedicamentClient(medicament1, client1, new Date());
medicamentClientDao.create(medicamentClient);
System.out.println("Médicament client créé pour : " + client1.getNom() + " - Médicament : " + medicament1.getNom());
        // Boucles de filtrage

        // Filtrer et afficher tous les utilisateurs
        System.out.println("\nListe des utilisateurs :");
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u.getNom() + " - " + u.getEmail());
        }

        // Filtrer et afficher tous les médicaments
        System.out.println("\nListe des médicaments :");
        List<Medicament> medicaments = medicamentDao.findAll(); // Get all medications
        if (medicaments != null && !medicaments.isEmpty()) {
            for (Medicament m : medicaments) {
                System.out.println(m.getNom() + " - Quantité : " + m.getQuantite());
            }
        } else {
            System.out.println("Aucun médicament trouvé.");
        }

        // Filtrer et afficher tous les fournisseurs
        System.out.println("\nListe des fournisseurs :");
        List<Fournisseur> fournisseurs = fournisseurDao.findAll();
        for (Fournisseur f : fournisseurs) {
            System.out.println(f.getNom() + " - Contact : " + f.getContact());
        }

        // Filtrer et afficher tous les clients
        System.out.println("\nListe des clients :");
        List<Client> clients = clientDao.findAll();
        for (Client c : clients) {
            System.out.println(c.getNom() + " - Email : " + c.getEmail());
        }

        // Nettoyage
        // Ajoutez ici le code pour supprimer les entités si nécessaire

        // Fermez la session Hibernate
        HibernateUtil.getSessionFactory().close();
    }
}