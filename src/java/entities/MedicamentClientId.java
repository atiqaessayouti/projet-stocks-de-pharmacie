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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicamentClientId that = (MedicamentClientId) o;

        if (medicamentId != that.medicamentId) return false;
        return clientId == that.clientId;
    }

    @Override
    public int hashCode() {
        int result = medicamentId;
        result = 31 * result + clientId;
        return result;
    }
}