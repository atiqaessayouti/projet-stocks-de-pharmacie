package test;

import dao.UserDao;
import dao.MedicamentDao;
import dao.ClientDAO;
import dao.ApprovisionnementDao;
import dao.FournisseurtDao; // Corrigé l'importation du DAO pour Fournisseur
import entities.User;
import entities.Medicament;
import entities.Client;
import entities.Approvisionnement;
import entities.Fournisseur; // Importation de l'entité Fournisseur
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Initialisation de la session Hibernate
        HibernateUtil.getSessionFactory();

        // Initialiser les DAO
        UserDao userDao = new UserDao();
        MedicamentDao medicamentDao = new MedicamentDao();
        ClientDAO clientDao = new ClientDAO();
        ApprovisionnementDao approvisionnementDao = new ApprovisionnementDao();
        FournisseurtDao fournisseurDao = new FournisseurtDao(); // Correction de l'initialisation

        try {
            // Créer plusieurs utilisateurs
            User user1 = new User("Alice", "alice@example.com", "securePassword");
            User user2 = new User("Bob", "bob@example.com", "securePassword");
            User user3 = new User("Charlie", "charlie@example.com", "securePassword");

            userDao.create(user1);
            userDao.create(user2);
            userDao.create(user3);

            System.out.println("Utilisateurs créés :");
            System.out.println(user1.getNom() + " - " + user1.getEmail());
            System.out.println(user2.getNom() + " - " + user2.getEmail());
            System.out.println(user3.getNom() + " - " + user3.getEmail());

            // Créer plusieurs médicaments
            Medicament medicament1 = new Medicament("Paracetamol", 100, new Date());
            Medicament medicament2 = new Medicament("Ibuprofène", 200, new Date());
            Medicament medicament3 = new Medicament("Aspirine", 150, new Date());

            medicamentDao.create(medicament1);
            medicamentDao.create(medicament2);
            medicamentDao.create(medicament3);

            System.out.println("Médicaments créés :");
            System.out.println(medicament1.getNom() + " - Quantité : " + medicament1.getQuantite());
            System.out.println(medicament2.getNom() + " - Quantité : " + medicament2.getQuantite());
            System.out.println(medicament3.getNom() + " - Quantité : " + medicament3.getQuantite());

            // Créer un fournisseur
            Fournisseur fournisseur = new Fournisseur("Fournisseur A", "contact@fournisseur.com");
            fournisseurDao.create(fournisseur);
            System.out.println("Fournisseur créé : " + fournisseur.getNom());

            // Créer un client
            Client client = new Client("Bob", "bob@example.com", "securePassword");
            clientDao.create(client);
            System.out.println("Client créé : " + client.getNom());

            // Créer un approvisionnement
            Approvisionnement approvisionnement = new Approvisionnement(new Date(), medicament1, fournisseur);
            approvisionnementDao.create(approvisionnement);
            System.out.println("Approvisionnement créé pour le médicament : " + medicament1.getNom());

            // Boucles de filtrage

            // Filtrer et afficher tous les utilisateurs
            System.out.println("Liste des utilisateurs :");
            List<User> users = userDao.findAll(); // Assurez-vous d'avoir une méthode findAll
            if (users != null && !users.isEmpty()) {
                for (User u : users) {
                    System.out.println(u.getNom() + " - " + u.getEmail());
                }
            } else {
                System.out.println("Aucun utilisateur trouvé.");
            }

            // Filtrer et afficher tous les médicaments
            System.out.println("Liste des médicaments :");
            List<Medicament> medicaments = medicamentDao.findAll(); // Assurez-vous d'avoir une méthode findAll
            if (medicaments != null && !medicaments.isEmpty()) {
                for (Medicament m : medicaments) {
                    System.out.println(m.getNom() + " - Quantité : " + m.getQuantite());
                }
            } else {
                System.out.println("Aucun médicament trouvé.");
            }

            // Filtrer et afficher tous les fournisseurs
            System.out.println("Liste des fournisseurs :");
            List<Fournisseur> fournisseurs = fournisseurDao.findAll(); // Assurez-vous d'avoir une méthode findAll
            if (fournisseurs != null && !fournisseurs.isEmpty()) {
                for (Fournisseur f : fournisseurs) {
                    System.out.println(f.getNom() + " - Contact : " + f.getContact());
                }
            } else {
                System.out.println("Aucun fournisseur trouvé.");
            }

            // Filtrer et afficher tous les clients
            System.out.println("Liste des clients :");
            List<Client> clients = clientDao.findAll(); // Assurez-vous d'avoir une méthode findAll
            if (clients != null && !clients.isEmpty()) {
                for (Client c : clients) {
                    System.out.println(c.getNom() + " - Email : " + c.getEmail());
                }
            } else {
                System.out.println("Aucun client trouvé.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermez la session Hibernate
            HibernateUtil.getSessionFactory().close();
        }
    }
}