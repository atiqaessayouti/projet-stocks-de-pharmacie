package dao;

import entities.Medicament;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import mapper.MedicamentStockCount; 
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
    
   
public List<Object[]> findCategorieWithMedicamentCount() {
    Session session = null;
    List<Object[]> result = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        result = session.createQuery(
            "SELECT c.nom, COUNT(m.id) " + // On compte le nombre de médicaments dans chaque catégorie
            "FROM Medicament m " +
            "JOIN m.categorie c " +  // On fait la jointure avec la catégorie
            "GROUP BY c.nom" // On groupe par catégorie
        ).list();

        session.getTransaction().commit();
    } catch (HibernateException e) {
        if (session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return result;
}
public List<Object[]> countByCategorie() {
    Session session = null;
    Transaction tx = null;
    List<Object[]> stats = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        stats = session.getNamedQuery("Medicament.countByCategorie").list();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        throw e;
    } finally {
        if (session != null) session.close();
    }
    return stats;
}

  public List<Object[]> findQuantiteParMedicament() {
    Session session = null;
    Transaction tx = null;
    List<Object[]> result = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        result = session.getNamedQuery("Medicament.quantiteParMedicament").list();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        throw e;
    } finally {
        if (session != null) session.close();
    }
    return result;
}
  public List<MedicamentStockCount> countStockPerMedicament() {
        Session session = null;
        List<MedicamentStockCount> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // La requête qui récupère les quantités totales par médicament
            List<Object[]> rows = session.createQuery(
                    "SELECT m.nom, SUM(m.quantite) FROM Medicament m GROUP BY m.nom"
            ).list();

            // Transformation des résultats en une liste de MedicamentStockCount
            result = new java.util.ArrayList<>();
            for (Object[] row : rows) {
                String nom = (String) row[0];
                Long quantite = (Long) row[1];
                result.add(new MedicamentStockCount(nom, quantite.intValue()));
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

 
}