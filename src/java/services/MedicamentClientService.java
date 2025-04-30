package services;

import dao.MedicamentClientDao;
import entities.MedicamentClient;

import java.util.List;

public class MedicamentClientService implements IService<MedicamentClient> {

    private final MedicamentClientDao dao;

    public MedicamentClientService() {
        this.dao = new MedicamentClientDao();
    }

    @Override
    public boolean create(MedicamentClient mc) {
        return dao.create(mc);
    }

    @Override
    public boolean update(MedicamentClient mc) {
        return dao.update(mc);
    }

    @Override
    public boolean delete(MedicamentClient mc) {
        return dao.delete(mc);
    }

    @Override
    public MedicamentClient findById(int id) {
        throw new UnsupportedOperationException("Utilisez plutôt findById(medicamentId, clientId)");
    }

    

    @Override
    public List<MedicamentClient> findAll() {
        return dao.findAll();
    }
}
