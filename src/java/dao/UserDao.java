
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Atiqa
 */
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
        
    }
    
         public List<User> findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        List<User> users = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            users = session.getNamedQuery("findByEmail").setParameter("email", email).list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }
         
     public User findByEmailAndPassword(String email, String motDePasse) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    User user = null;
    try {
        user = (User) session.createQuery("FROM User u WHERE u.email = :email AND u.motDePasse = :mdp")
                .setParameter("email", email)
                .setParameter("mdp", motDePasse)
                .uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }
    return user;
}
    
}
