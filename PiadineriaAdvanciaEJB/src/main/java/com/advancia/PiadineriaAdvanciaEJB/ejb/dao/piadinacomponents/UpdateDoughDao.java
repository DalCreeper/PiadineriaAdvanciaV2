package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class UpdateDoughDao {
    public void update(int id, DoughEJB d, EntityManager em) {
        try {
            DoughEJB existingDoughEJB = em.find(DoughEJB.class, id);
            if(existingDoughEJB != null) {
                existingDoughEJB.setType(d.getType());
                existingDoughEJB.setDescription(d.getDescription());
                existingDoughEJB.setPrice(d.getPrice());
                em.merge(existingDoughEJB);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating dough with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, DoughEJB d, EntityManager em) {
        try {
            DoughEJB existingDoughEJB = em.createQuery("SELECT d FROM DoughEJB d WHERE d.type = :type", DoughEJB.class)
                                    .setParameter("type", type)
                                    .getSingleResult();
            if(existingDoughEJB != null) {
                existingDoughEJB.setType(d.getType());
                existingDoughEJB.setDescription(d.getDescription());
                existingDoughEJB.setPrice(d.getPrice());
                em.merge(existingDoughEJB);
            } else {
                throw new DBException("Dough with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating dough with type: " + type, e);
        }
    }
}