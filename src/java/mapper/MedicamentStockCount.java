package mapper;

public class MedicamentStockCount {
    private String nom;
    private long quantite;

    public MedicamentStockCount(String nom, long quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public long getQuantite() {
        return quantite;
    }
}
