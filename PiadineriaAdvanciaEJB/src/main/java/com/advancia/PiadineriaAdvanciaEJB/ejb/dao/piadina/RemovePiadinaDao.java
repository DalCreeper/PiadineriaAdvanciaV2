package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.PiadinaEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class RemovePiadinaDao {
	public void deletePiadina(EntityManager em, int piadinaId) {
		try {
			PiadinaEJB piadinaEJB = em.find(PiadinaEJB.class, piadinaId);
            if(piadinaEJB != null) {
                piadinaEJB.getMeatBase().clear();
                piadinaEJB.getSauces().clear();
                piadinaEJB.getOptionalElements().clear();
                em.remove(piadinaEJB);
            } else {
                throw new DBException("Piadina with ID " + piadinaId + " not found.");
            }
		} catch(Exception e) {
			throw new DBException("Error while deleting piadina from DB.", e);
        }
	}
}