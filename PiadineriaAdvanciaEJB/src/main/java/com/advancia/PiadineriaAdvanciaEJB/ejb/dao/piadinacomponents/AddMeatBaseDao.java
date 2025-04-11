package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AddMeatBaseDao {
    public void add(MeatBaseEJB mt, EntityManager em) {
        try {
            em.persist(mt);
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }
}