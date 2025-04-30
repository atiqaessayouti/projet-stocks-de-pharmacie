package mapper;

public class MedicamentCategorieCount {
    private String categorie;
    private long nbMedicaments;

    public MedicamentCategorieCount(String categorie, long nbMedicaments) {
        this.categorie = categorie;
        this.nbMedicaments = nbMedicaments;
    }

    public String getCategorie() {
        return categorie;
    }

    public long getNbMedicaments() {
        return nbMedicaments;
    }
}
