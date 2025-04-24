package dao;

import entities.Fournisseur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import util.HibernateUtil;

public class FournisseurtDao extends AbstractDao<Fournisseur> {

    public FournisseurtDao() {
        super(Fournisseur.class);
    }

    public List<Fournisseur> findByNom(String Nom) {
        Session session = null;
        Transaction tx = null;
        List<Fournisseur> users = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            users = session.getNamedQuery("findByNom").setParameter("Nom", Nom).list();
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

    
    

    
}