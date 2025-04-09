package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int quantite;

    @Temporal(TemporalType.DATE)
    private Date datePeremption;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicamentClient> medicamentClients;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL)
    private List<Approvisionnement> approvisionnements;

    public Medicament() {}

    public Medicament(String nom, int quantite, Date datePeremption) {
        this.nom = nom;
        this.quantite = quantite;
        this.datePeremption = datePeremption;
    }

    // Getters and Setters
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
}