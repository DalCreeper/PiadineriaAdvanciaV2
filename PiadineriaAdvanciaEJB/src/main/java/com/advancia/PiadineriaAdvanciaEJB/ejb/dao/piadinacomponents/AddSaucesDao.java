package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AddSaucesDao {
    public void add(SaucesEJB s, EntityManager em) {
        try {
            em.persist(s);
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }
}