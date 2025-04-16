package dao;

import entities.Medicament;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class MedicamentDao extends AbstractDao<Medicament> {

    public MedicamentDao() {
        super(Medicament.class);
    }

    public List<Medicament> findBetweenDate(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Medicament> medicaments = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            medicaments = session.getNamedQuery("findBetweenDate")
                                 .setParameter("m1", d1)
                                 .setParameter("m2", d2)
                                 .list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medicaments;
    }

    public List<Medicament> findByQuantite(int quantite) {
        Session session = null;
        Transaction tx = null;
        List<Medicament> medicaments = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            medicaments = session.getNamedQuery("findByQuantite")
                                 .setParameter("quantite", quantite)
                                 .list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medicaments;
    }
    

   
}