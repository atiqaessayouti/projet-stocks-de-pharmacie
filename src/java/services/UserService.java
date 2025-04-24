package services;

import dao.UserDao;
import entities.Admin;
import entities.User;
import java.util.List;

public class UserService implements IService<User> {

    private final UserDao ud;

    public UserService() {
        this.ud = new UserDao();
    }

    @Override
    public boolean create(User o) {
        return ud.create(o);
    }

    @Override
    public boolean update(User o) {
        return ud.update(o);
    }

    @Override
    public boolean delete(User o) {
        return ud.delete(o);
    }

    @Override
    public List<User> findAll() {
        return ud.findAll();
    }

    @Override
    public User findById(int id) {
        return ud.findById(id);
    }

    public List<User> findByEmail(String email) {
        return ud.findByEmail(email);
    }

    // Méthode pour connecter un utilisateur avec son email et mot de passe
   public Admin adminLogin(String email, String motDePasse) {
    List<User> users = ud.findByEmail(email);
    if (users != null && !users.isEmpty()) {
        User user = users.get(0);
        if (user instanceof Admin && user.getMotDePasse().equals(motDePasse)) {
            return (Admin) user;
        }
    }
    return null;
}

}
