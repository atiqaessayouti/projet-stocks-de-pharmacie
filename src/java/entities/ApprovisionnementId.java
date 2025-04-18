package entities;

import javax.persistence.Column;
import java.io.Serializable;

public class ApprovisionnementId implements Serializable {

    @Column(name = "medicament_id")
    private int medicamentId;

    @Column(name = "fournisseur_id")
    private int fournisseurId;

    public ApprovisionnementId() {
    }

    public ApprovisionnementId(int medicamentId, int fournisseurId) {
        this.medicamentId = medicamentId;
        this.fournisseurId = fournisseurId;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    public int getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(int fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    
}