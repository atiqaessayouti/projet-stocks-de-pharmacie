package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    public Medicament() {}

    public Medicament(String nom, int quantite, LocalDate datePeremption) {
        this.nom = nom;
        this.quantite = quantite;
        this.datePeremption = datePeremption;
    }

    // Getters et Setters
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

    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }
}