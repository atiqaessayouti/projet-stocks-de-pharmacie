package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicamentClient> medicamentClients;

    public Client() {}

    public Client(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    // Getters and Setters
    public List<MedicamentClient> getMedicamentClients() {
        return medicamentClients;
    }

    public void setMedicamentClients(List<MedicamentClient> medicamentClients) {
        this.medicamentClients = medicamentClients;
    }
}