package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fournisseurs")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String contact;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    private List<Approvisionnement> approvisionnements;

    public Fournisseur() {}

    public Fournisseur(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Approvisionnement> getApprovisionnements() {
        return approvisionnements;
    }
}