package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class RemoveOptionalElementsDao {
    public void remove(int id, EntityManager em) {
        try {
            OptionalElementsEJB oe = em.find(OptionalElementsEJB.class, id);
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
        	OptionalElementsEJB oe = em.createQuery("SELECT oe FROM OptionalElementsEJB oe WHERE oe.type = :type", OptionalElementsEJB.class)
	                                .setParameter("type", type)
	                                .getSingleResult();
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with type: " + type, e);
        }
    }
}