package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "approvisionnements")
public class Approvisionnement {

    @EmbeddedId
    private ApprovisionnementId id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @MapsId("medicamentId") // Utilisation de la clé intégrée
    @JoinColumn(name = "medicament_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Medicament medicament;

    @ManyToOne
    @MapsId("fournisseurId") // Utilisation de la clé intégrée
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Fournisseur fournisseur;

    public Approvisionnement() {}

    public Approvisionnement(Date date, Medicament medicament, Fournisseur fournisseur) {
        this.date = date;
        this.id = new ApprovisionnementId(medicament.getId(), fournisseur.getId());
        this.medicament = medicament;
        this.fournisseur = fournisseur;
    }

    // Getters and Setters
    public ApprovisionnementId getId() {
        return id;
    }

    public void setId(ApprovisionnementId id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
        this.id.setMedicamentId(medicament.getId());
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        this.id.setFournisseurId(fournisseur.getId());
    }
}