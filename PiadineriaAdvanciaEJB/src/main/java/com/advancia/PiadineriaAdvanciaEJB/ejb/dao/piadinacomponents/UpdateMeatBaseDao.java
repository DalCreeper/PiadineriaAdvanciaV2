package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class UpdateMeatBaseDao {
    public void update(int id, MeatBaseEJB mt, EntityManager em) {
        try {
            MeatBaseEJB existingMeatBaseEJB = em.find(MeatBaseEJB.class, id);
            if(existingMeatBaseEJB != null) {
            	existingMeatBaseEJB.setType(mt.getType());
            	existingMeatBaseEJB.setDescription(mt.getDescription());
            	existingMeatBaseEJB.setPrice(mt.getPrice());
                em.merge(existingMeatBaseEJB);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, MeatBaseEJB mt, EntityManager em) {
        try {
        	MeatBaseEJB existingMeatBaseEJB = em.createQuery("SELECT mt FROM MeatBaseEJB mt WHERE mt.type = :type", MeatBaseEJB.class)
	                                      .setParameter("type", type)
	                                      .getSingleResult();
            if(existingMeatBaseEJB != null) {
                existingMeatBaseEJB.setType(mt.getType());
                existingMeatBaseEJB.setDescription(mt.getDescription());
                existingMeatBaseEJB.setPrice(mt.getPrice());
                em.merge(existingMeatBaseEJB);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with type: " + type, e);
        }
    }
}