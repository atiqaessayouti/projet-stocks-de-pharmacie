
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Approvisionnement;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author AMINE
 */
public class ApprovisionnementDao extends AbstractDao<Approvisionnement> {

    public ApprovisionnementDao() {
        super(Approvisionnement.class);
    } 
}
