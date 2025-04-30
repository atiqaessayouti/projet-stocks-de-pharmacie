package services;

import dao.MedicamentDao;
import entities.Medicament;
import java.util.List;
import java.util.Date;
import mapper.MedicamentCount;
import mapper.MedicamentStockCount;
import org.hibernate.Query;

public class MedicamentService implements IService<Medicament> {

    private final MedicamentDao medicamentDao;

    public MedicamentService() {
        this.medicamentDao = new MedicamentDao();
    }

    @Override
    public boolean create(Medicament medicament) {
        return medicamentDao.create(medicament);
    }

    @Override
    public boolean update(Medicament medicament) {
        return medicamentDao.update(medicament);
    }

    @Override
    public boolean delete(Medicament medicament) {
        return medicamentDao.delete(medicament);
    }

    @Override
    public List<Medicament> findAll() {
        return medicamentDao.findAll();
    }
   
    @Override
    public Medicament findById(int id) {
        return medicamentDao.findById(id);
    }

    public List<Medicament> findByQuantite(int quantite) {
        return medicamentDao.findByQuantite(quantite);
    }

    public List<Medicament> findBetweenDate(Date startDate, Date endDate) {
        return medicamentDao.findBetweenDate(startDate, endDate);
    }

    public List<MedicamentStockCount> countStockPerMedicament() {
        return medicamentDao.countStockPerMedicament();
    }

    // Ajout de la méthode pour récupérer les statistiques par catégorie
    public List<Object[]> getCategorieStats() {
        return medicamentDao.findCategorieWithMedicamentCount();
    }
}
