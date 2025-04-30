package services;

import dao.ClientDAO;
import entities.Client;
import java.util.List;

public class ClientService implements IService<Client> {

    private ClientDAO clientDao;

    public ClientService() {
        this.clientDao = new ClientDAO();
    }


    public boolean create(Client client) {
        return clientDao.create(client);
    }

  
    public boolean update(Client client) {
        return clientDao.update(client);
    }

    @Override
    public boolean delete(Client client) {
        return clientDao.delete(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientDao.findById(id);
    }
}
