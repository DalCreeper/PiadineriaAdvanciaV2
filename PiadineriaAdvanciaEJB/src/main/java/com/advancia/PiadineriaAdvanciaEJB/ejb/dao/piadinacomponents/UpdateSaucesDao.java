package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class UpdateSaucesDao {
    public void update(int id, SaucesEJB s, EntityManager em) {
        try {
            SaucesEJB existingSauce = em.find(SaucesEJB.class, id);
            if(existingSauce != null) {
            	existingSauce.setType(s.getType());
            	existingSauce.setDescription(s.getDescription());
            	existingSauce.setPrice(s.getPrice());
                em.merge(existingSauce);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating sauces with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, SaucesEJB s, EntityManager em) {
        try {
        	SaucesEJB existingSaucesEJB = em.createQuery("SELECT s FROM SaucesEJB s WHERE s.type = :type", SaucesEJB.class)
                                      .setParameter("type", type)
                                      .getSingleResult();
            if(existingSaucesEJB != null) {
            	existingSaucesEJB.setType(s.getType());
            	existingSaucesEJB.setDescription(s.getDescription());
            	existingSaucesEJB.setPrice(s.getPrice());
                em.merge(existingSaucesEJB);
            } else {
                throw new DBException("Sauces with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating sauces with type: " + type, e);
        }
    }
}