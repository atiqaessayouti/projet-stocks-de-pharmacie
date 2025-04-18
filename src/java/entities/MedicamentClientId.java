package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedicamentClientId implements Serializable {

    @Column(name = "medicament_id")
    private int medicamentId;

    @Column(name = "client_id")
    private int clientId;

    public MedicamentClientId() {
    }

    public MedicamentClientId(int medicamentId, int clientId) {
        this.medicamentId = medicamentId;
        this.clientId = clientId;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    
}