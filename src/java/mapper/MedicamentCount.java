package mapper;

/**
 * Mapper pour représenter une catégorie avec le nombre de médicaments
 */
public class MedicamentCount {
    private String categorie;
    private long nbMedicaments;

    public MedicamentCount(String categorie, long nbMedicaments) {
        this.categorie = categorie;
        this.nbMedicaments = nbMedicaments;
    }

    // Getters requis par Gson pour la conversion en JSON
    public String getCategorie() {
        return categorie;
    }

    public long getNbMedicaments() {
        return nbMedicaments;
    }
}
