
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.AbstractDao;
import entities.Medicament;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *

 */
public class MedicamentDao extends AbstractDao<Medicament> {

    public MedicamentDao() {
        super(Medicament.class);
    } 
}
