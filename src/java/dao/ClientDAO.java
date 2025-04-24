package dao;

import entities.Client;

public class ClientDAO extends AbstractDao<Client> {

    public ClientDAO() {
        super(Client.class);
    }
}