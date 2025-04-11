package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AddDoughDao {
    public void add(DoughEJB d, EntityManager em) {
        try {
            em.persist(d);
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }
}