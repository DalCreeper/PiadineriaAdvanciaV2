package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AddOptionalElementsDao {
    public void add(OptionalElementsEJB oe, EntityManager em) {
        try {
            em.persist(oe);
        } catch(Exception e) {
            throw new DBException("Error while adding optional elements.", e);
        }
    }
}