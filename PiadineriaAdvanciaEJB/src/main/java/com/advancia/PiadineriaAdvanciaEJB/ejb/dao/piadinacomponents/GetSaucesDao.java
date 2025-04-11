package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class GetSaucesDao {
    private static final String GET_SAUCES_BY_ID = "SELECT s FROM SaucesEJB s WHERE s.id = :id";
    private static final String GET_SAUCES_BY_TYPE = "SELECT s FROM SaucesEJB s WHERE s.type = :type";

    public SaucesEJB get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_SAUCES_BY_ID, SaucesEJB.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces with ID: " + id, e);
        }
    }
    
    public SaucesEJB getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_SAUCES_BY_TYPE, SaucesEJB.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces with type: " + type, e);
        }
    }
}