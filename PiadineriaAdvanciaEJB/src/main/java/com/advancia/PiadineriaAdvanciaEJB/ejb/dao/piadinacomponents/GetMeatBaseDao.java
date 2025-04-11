package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class GetMeatBaseDao {
    private static final String GET_MEAT_BASE_BY_ID = "SELECT m FROM MeatBaseEJB m WHERE m.id = :id";
    private static final String GET_MEATBASE_BY_TYPE = "SELECT m FROM MeatBaseEJB m WHERE m.type = :type";

    public MeatBaseEJB get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_MEAT_BASE_BY_ID, MeatBaseEJB.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base with ID: " + id, e);
        }
    }
    
    public MeatBaseEJB getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_MEATBASE_BY_TYPE, MeatBaseEJB.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meatBase with type: " + type, e);
        }
    }
}