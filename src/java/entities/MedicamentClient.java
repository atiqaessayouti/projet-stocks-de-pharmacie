package entities;

import javax.persistence.*;

@Entity
@Table(name = "medicament_clients")
@IdClass(MedicamentClientId.class)
public class MedicamentClient {

    @Id
    @Column(name = "medicament_id")
    private int medicamentId;

    @Id
    @Column(name = "client_id")
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "medicament_id", insertable = false, updatable = false)
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    public MedicamentClient() {
    }

    // Getters et Setters

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

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
        this.medicamentId = medicament.getId();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        this.clientId = client.getId();
    }
}