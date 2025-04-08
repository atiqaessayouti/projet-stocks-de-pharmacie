
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import entities.Fournisseur;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *

 */
public class FournisseurDao extends AbstractDao<Fournisseur> {

    public FournisseurDao() {
        super(Fournisseur.class);
    } 
}
