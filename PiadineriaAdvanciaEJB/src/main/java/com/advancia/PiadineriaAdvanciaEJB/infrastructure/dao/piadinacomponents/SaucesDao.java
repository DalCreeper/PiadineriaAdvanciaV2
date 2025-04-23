package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.SaucesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class SaucesDao {
    private static final String GET_SAUCES_BY_ID = "SELECT s FROM SaucesEntity s WHERE s.id = :id";
    private static final String GET_SAUCES_BY_TYPE = "SELECT s FROM SaucesEntity s WHERE s.type = :type";

    public SaucesEntity get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_SAUCES_BY_ID, SaucesEntity.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces with ID: " + id, e);
        }
    }

    public SaucesEntity getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_SAUCES_BY_TYPE, SaucesEntity.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces with type: " + type, e);
        }
    }

    public void add(SaucesEntity s, EntityManager em) {
        try {
            em.persist(s);
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }

    public void update(int id, SaucesEntity s, EntityManager em) {
        try {
            SaucesEntity existingSaucesEntity = em.find(SaucesEntity.class, id);
            if(existingSaucesEntity != null) {
                existingSaucesEntity.setType(s.getType());
                existingSaucesEntity.setDescription(s.getDescription());
                existingSaucesEntity.setPrice(s.getPrice());
                em.merge(existingSaucesEntity);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating sauces with ID: " + id, e);
        }
    }

    public void updateByType(String type, SaucesEntity s, EntityManager em) {
        try {
            SaucesEntity existingSaucesEntity = em.createQuery("SELECT s FROM SaucesEntity s WHERE s.type = :type", SaucesEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(existingSaucesEntity != null) {
                existingSaucesEntity.setType(s.getType());
                existingSaucesEntity.setDescription(s.getDescription());
                existingSaucesEntity.setPrice(s.getPrice());
                em.merge(existingSaucesEntity);
            } else {
                throw new DBException("Sauces with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating sauces with type: " + type, e);
        }
    }

    public void remove(int id, EntityManager em) {
        try {
            SaucesEntity saucesEntity = em.find(SaucesEntity.class, id);
            if(saucesEntity != null) {
                em.remove(saucesEntity);
            } else {
                throw new DBException("Sauces with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing sauces with ID: " + id, e);
        }
    }

    public void removeByType(String type, EntityManager em) {
        try {
            SaucesEntity saucesEntity = em.createQuery("SELECT s FROM SaucesEntity s WHERE s.type = :type", SaucesEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(saucesEntity != null) {
                em.remove(saucesEntity);
            } else {
                throw new DBException("Sauces with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing sauces with type: " + type, e);
        }
    }
}