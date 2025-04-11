package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class GetOptionalElementsDao {
    private static final String GET_OPTIONAL_ELEMENTS_BY_ID = "SELECT oe FROM OptionalElementsEJB oe WHERE oe.id = :id";
    private static final String GET_OPTIONAL_ELEMENTS_BY_TYPE = "SELECT oe FROM OptionalElementsEJB oe WHERE oe.type = :type";

    public OptionalElementsEJB get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_OPTIONAL_ELEMENTS_BY_ID, OptionalElementsEJB.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving optional elements with ID: " + id, e);
        }
    }
    
    public OptionalElementsEJB getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_OPTIONAL_ELEMENTS_BY_TYPE, OptionalElementsEJB.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving optional elements with type: " + type, e);
        }
    }
}