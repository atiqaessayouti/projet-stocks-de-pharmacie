package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "approvisionnements")
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "medicament_id")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "date")
    private LocalDate date;

    public Approvisionnement() {}

    public Approvisionnement(Medicament medicament, Fournisseur fournisseur, int quantite, LocalDate date) {
        this.medicament = medicament;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
        this.date = date;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}