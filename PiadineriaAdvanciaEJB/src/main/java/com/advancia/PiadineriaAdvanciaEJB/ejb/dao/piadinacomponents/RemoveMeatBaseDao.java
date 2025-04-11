package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class RemoveMeatBaseDao {
    public void remove(int id, EntityManager em) {
        try {
            MeatBaseEJB meatBaseEJB = em.find(MeatBaseEJB.class, id);
            if(meatBaseEJB != null) {
                em.remove(meatBaseEJB);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meat base with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
        	MeatBaseEJB meatBaseEJB = em.createQuery("SELECT m FROM MeatBaseEJB m WHERE m.type = :type", MeatBaseEJB.class)
	                              .setParameter("type", type)
	                              .getSingleResult();
            if(meatBaseEJB != null) {
                em.remove(meatBaseEJB);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meatBase with type: " + type, e);
        }
    }
}