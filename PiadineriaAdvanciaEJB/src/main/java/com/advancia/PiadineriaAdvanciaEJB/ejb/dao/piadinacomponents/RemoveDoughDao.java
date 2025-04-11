package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class RemoveDoughDao {
    public void remove(int id, EntityManager em) {
        try {
            DoughEJB doughEJB = em.find(DoughEJB.class, id);
            if(doughEJB != null) {
                em.remove(doughEJB);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with ID: " + id, e);
        }
    }
    
    public void removeByType(String type, EntityManager em) {
        try {
            DoughEJB doughEJB = em.createQuery("SELECT d FROM DoughEJB d WHERE d.type = :type", DoughEJB.class)
                            .setParameter("type", type)
                            .getSingleResult();
            if(doughEJB != null) {
                em.remove(doughEJB);
            } else {
                throw new DBException("Dough with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with type: " + type, e);
        }
    }
}