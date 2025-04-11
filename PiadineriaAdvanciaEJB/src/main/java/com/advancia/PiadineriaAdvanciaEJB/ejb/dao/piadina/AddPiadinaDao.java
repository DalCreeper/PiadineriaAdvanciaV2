package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.PiadinaEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class AddPiadinaDao {
	public void insertPiadina(EntityManager em, PiadinaEJB piadinaEJB) {
		try {
			em.merge(piadinaEJB);
		} catch(Exception e) {
            throw new DBException("Error while inserting piadina into DB.", e);
        }
	}
}