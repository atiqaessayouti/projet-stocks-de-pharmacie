package entities;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "medicament_id", insertable = false, updatable = false)
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    public MedicamentClient() {
    }

    public MedicamentClient(Medicament medicament, Client client, Date dateAchat) {
        this.medicament = medicament;
        this.client = client;
        this.dateAchat = dateAchat;
        this.medicamentId = medicament.getId(); // Assurez-vous que les IDs sont correctement définis
        this.clientId = client.getId();
    }

    // Getters et Setters
    // ...
}