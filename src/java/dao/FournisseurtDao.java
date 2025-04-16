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

    public List<Fournisseur> findCours(Fournisseur f) {
        Session session = null;
        Transaction tx = null;
        List<Fournisseur> Fournisseur= null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Fournisseur = session.getNamedQuery("findByNom").setParameter("nom", f.getNom()).list();
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
        return Fournisseur;
    }

    
    

    
}