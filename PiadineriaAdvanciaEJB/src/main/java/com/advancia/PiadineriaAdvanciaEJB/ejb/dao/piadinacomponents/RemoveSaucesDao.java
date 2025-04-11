package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class RemoveSaucesDao {
    public void remove(int id, EntityManager em) {
        try {
            SaucesEJB saucesEJB = em.find(SaucesEJB.class, id);
            if(saucesEJB != null) {
                em.remove(saucesEJB);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing sauces with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
        	SaucesEJB saucesEJB = em.createQuery("SELECT s FROM SaucesEJB s WHERE s.type = :type", SaucesEJB.class)
                              .setParameter("type", type)
                              .getSingleResult();
            if(saucesEJB != null) {
                em.remove(saucesEJB);
            } else {
                throw new DBException("Sauces with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing sauces with type: " + type, e);
        }
    }
}