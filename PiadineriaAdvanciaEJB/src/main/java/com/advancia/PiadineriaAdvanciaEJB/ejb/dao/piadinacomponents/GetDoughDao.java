package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class GetDoughDao {
    private static final String GET_DOUGH_BY_ID = "SELECT d FROM DoughEJB d WHERE d.id = :id";
    private static final String GET_DOUGH_BY_TYPE = "SELECT d FROM DoughEJB d WHERE d.type = :type";

    public DoughEJB get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_DOUGH_BY_ID, DoughEJB.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving dough with ID: " + id, e);
        }
    }
    
    public DoughEJB getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_DOUGH_BY_TYPE, DoughEJB.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving dough with type: " + type, e);
        }
    }
}