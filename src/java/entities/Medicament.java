package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "findBetweenDate", query = "FROM Medicament WHERE datePeremption BETWEEN :m1 AND :m2"),
    @NamedQuery(name = "findByQuantite", query = "FROM Medicament WHERE quantite = :quantite"),
   
    @NamedQuery(
    name = "Medicament.quantiteParMedicament",
    query = "SELECT m.nom AS nomMedicament, SUM(m.quantite) AS quantiteTotale " +
            "FROM Medicament m " +
            "GROUP BY m.nom " +
            "ORDER BY quantiteTotale DESC"
)
    

} )
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String categorie;  // ➔ ajout de la catégorie

    @Column(nullable = false)
    private int quantite;

    @Temporal(TemporalType.DATE)
    @Column(name = "datePeremption", nullable = false)
    private Date datePeremption;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicamentClient> medicamentClients;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL)
    private List<Approvisionnement> approvisionnements;

    // -------------------- Constructeurs --------------------

    public Medicament() {
    }

    public Medicament(String nom, String categorie, int quantite, Date datePeremption) {
        this.nom = nom;
        this.categorie = categorie;
        this.quantite = quantite;
        this.datePeremption = datePeremption;
    }
     public Medicament(String nom, int quantite, Date datePeremption) {
        this.nom = nom;
       
        this.quantite = quantite;
        this.datePeremption = datePeremption;
    }

    // -------------------- Getters & Setters --------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public List<MedicamentClient> getMedicamentClients() {
        return medicamentClients;
    }

    public void setMedicamentClients(List<MedicamentClient> medicamentClients) {
        this.medicamentClients = medicamentClients;
    }

    public List<Approvisionnement> getApprovisionnements() {
        return approvisionnements;
    }

    public void setApprovisionnements(List<Approvisionnement> approvisionnements) {
        this.approvisionnements = approvisionnements;
    }
}
