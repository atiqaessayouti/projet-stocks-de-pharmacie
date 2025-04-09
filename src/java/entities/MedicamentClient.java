package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medicament_clients")
public class MedicamentClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "medicament_id", nullable = false)
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat")
    private Date dateAchat;

    public MedicamentClient() {}

    public MedicamentClient(Medicament medicament, Client client, Date dateAchat) {
        this.medicament = medicament;
        this.client = client;
        this.dateAchat = dateAchat;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    @Override
    public String toString() {
        return "MedicamentClient{" +
                "id=" + id +
                ", medicament=" + medicament.getNom() +
                ", client=" + client.getNom() +
                ", dateAchat=" + dateAchat +
                '}';
    }
}