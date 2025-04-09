/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Medicament;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author a
 */
public class MedicamentDao implements IDao<Medicament>{

    @Override
    public boolean create(Medicament o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Medicament o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Medicament o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public List<Medicament> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Medicament> etudiants = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            etudiants = session.createQuery("from Etudiant").list();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etudiants;
    }

    @Override
    public Medicament findById(int id) {
        Session session = null;
        Transaction tx = null;
        Medicament etudiant = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            etudiant = (Medicament) session.get(Medicament.class, id);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null)
                tx.rollback();
        }finally{
            if(session != null)
                session.close();
        }
        return etudiant;
    }
    
}