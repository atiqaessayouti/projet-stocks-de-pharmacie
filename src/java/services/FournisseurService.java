package services;

import dao.FournisseurtDao;
import entities.Fournisseur;
import java.util.List;

public class FournisseurService implements IService<Fournisseur> {

    private final FournisseurtDao fournisseurDao;

    public FournisseurService() {
        this.fournisseurDao = new FournisseurtDao();
    }

    @Override
    public boolean create(Fournisseur fournisseur) {
        return fournisseurDao.create(fournisseur);
    }

    @Override
    public boolean update(Fournisseur fournisseur) {
        return fournisseurDao.update(fournisseur);
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        return fournisseurDao.delete(fournisseur);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurDao.findAll();
    }

    @Override
    public Fournisseur findById(int id) {
        return fournisseurDao.findById(id);
    }
}

