package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class UpdateOptionalElementsDao {
    public void update(int id, OptionalElementsEJB oe, EntityManager em) {
        try {
            OptionalElementsEJB existingElement = em.find(OptionalElementsEJB.class, id);
            if(existingElement != null) {
            	existingElement.setType(oe.getType());
            	existingElement.setDescription(oe.getDescription());
            	existingElement.setPrice(oe.getPrice());
                em.merge(existingElement);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with ID: " + id, e);
        }
    }
    
    public void updateByType(String type, OptionalElementsEJB oe, EntityManager em) {
        try {
        	OptionalElementsEJB existingOptionalElementsEJB = em.createQuery("SELECT oe FROM OptionalElementsEJB oe WHERE oe.type = :type", OptionalElementsEJB.class)
				                                          .setParameter("type", type)
			                                              .getSingleResult();
            if(existingOptionalElementsEJB != null) {
            	existingOptionalElementsEJB.setType(oe.getType());
            	existingOptionalElementsEJB.setDescription(oe.getDescription());
            	existingOptionalElementsEJB.setPrice(oe.getPrice());
                em.merge(existingOptionalElementsEJB);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with type: " + type, e);
        }
    }
}