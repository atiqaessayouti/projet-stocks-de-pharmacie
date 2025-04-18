/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MedicamentClient;

/**
 *
 * @author HP
 */

   public class MedicamentClientDao  extends AbstractDao<MedicamentClient> {

    public MedicamentClientDao () {
        super(MedicamentClient .class);
    }
}
