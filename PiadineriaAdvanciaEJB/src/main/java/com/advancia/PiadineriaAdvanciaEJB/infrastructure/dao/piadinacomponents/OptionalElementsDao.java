package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.OptionalElementsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class OptionalElementsDao {
    private static final String GET_OPTIONAL_ELEMENTS_BY_ID = "SELECT oe FROM OptionalElementsEntity oe WHERE oe.id = :id";
    private static final String GET_OPTIONAL_ELEMENTS_BY_TYPE = "SELECT oe FROM OptionalElementsEntity oe WHERE oe.type = :type";

    public OptionalElementsEntity get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_OPTIONAL_ELEMENTS_BY_ID, OptionalElementsEntity.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving optional elements with ID: " + id, e);
        }
    }

    public OptionalElementsEntity getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_OPTIONAL_ELEMENTS_BY_TYPE, OptionalElementsEntity.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving optional elements with type: " + type, e);
        }
    }

    public void add(OptionalElementsEntity oe, EntityManager em) {
        try {
            em.persist(oe);
        } catch(Exception e) {
            throw new DBException("Error while adding optional elements.", e);
        }
    }

    public void update(int id, OptionalElementsEntity oe, EntityManager em) {
        try {
            OptionalElementsEntity existingOptionalElementsEntity = em.find(OptionalElementsEntity.class, id);
            if(existingOptionalElementsEntity != null) {
                existingOptionalElementsEntity.setType(oe.getType());
                existingOptionalElementsEntity.setDescription(oe.getDescription());
                existingOptionalElementsEntity.setPrice(oe.getPrice());
                em.merge(existingOptionalElementsEntity);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with ID: " + id, e);
        }
    }

    public void updateByType(String type, OptionalElementsEntity oe, EntityManager em) {
        try {
            OptionalElementsEntity existingOptionalElementsEntity = em.createQuery("SELECT oe FROM OptionalElementsEntity oe WHERE oe.type = :type", OptionalElementsEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(existingOptionalElementsEntity != null) {
                existingOptionalElementsEntity.setType(oe.getType());
                existingOptionalElementsEntity.setDescription(oe.getDescription());
                existingOptionalElementsEntity.setPrice(oe.getPrice());
                em.merge(existingOptionalElementsEntity);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating optional elements with type: " + type, e);
        }
    }

    public void remove(int id, EntityManager em) {
        try {
            OptionalElementsEntity oe = em.find(OptionalElementsEntity.class, id);
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("Optional element with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with ID: " + id, e);
        }
    }

    public void removeByType(String type, EntityManager em) {
        try {
            OptionalElementsEntity oe = em.createQuery("SELECT oe FROM OptionalElementsEntity oe WHERE oe.type = :type", OptionalElementsEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(oe != null) {
                em.remove(oe);
            } else {
                throw new DBException("OptionalElements with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing optional element with type: " + type, e);
        }
    }
}