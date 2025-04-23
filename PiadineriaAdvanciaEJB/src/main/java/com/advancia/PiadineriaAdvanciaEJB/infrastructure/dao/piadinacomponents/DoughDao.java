package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.DoughEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class DoughDao {
    private static final String GET_DOUGH_BY_ID = "SELECT d FROM DoughEntity d WHERE d.id = :id";
    private static final String GET_DOUGH_BY_TYPE = "SELECT d FROM DoughEntity d WHERE d.type = :type";

    public DoughEntity get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_DOUGH_BY_ID, DoughEntity.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving dough with ID: " + id, e);
        }
    }

    public DoughEntity getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_DOUGH_BY_TYPE, DoughEntity.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving dough with type: " + type, e);
        }
    }

    public void add(DoughEntity d, EntityManager em) {
        try {
            em.persist(d);
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }

    public void update(int id, DoughEntity d, EntityManager em) {
        try {
            DoughEntity existingDoughEntity = em.find(DoughEntity.class, id);
            if(existingDoughEntity != null) {
                existingDoughEntity.setType(d.getType());
                existingDoughEntity.setDescription(d.getDescription());
                existingDoughEntity.setPrice(d.getPrice());
                em.merge(existingDoughEntity);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating dough with ID: " + id, e);
        }
    }

    public void updateByType(String type, DoughEntity d, EntityManager em) {
        try {
            DoughEntity existingDoughEntity = em.createQuery("SELECT d FROM DoughEntity d WHERE d.type = :type", DoughEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(existingDoughEntity != null) {
                existingDoughEntity.setType(d.getType());
                existingDoughEntity.setDescription(d.getDescription());
                existingDoughEntity.setPrice(d.getPrice());
                em.merge(existingDoughEntity);
            } else {
                throw new DBException("Dough with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating dough with type: " + type, e);
        }
    }

    public void remove(int id, EntityManager em) {
        try {
            DoughEntity doughEntity = em.find(DoughEntity.class, id);
            if(doughEntity != null) {
                em.remove(doughEntity);
            } else {
                throw new DBException("Dough with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with ID: " + id, e);
        }
    }

    public void removeByType(String type, EntityManager em) {
        try {
            DoughEntity doughEntity = em.createQuery("SELECT d FROM DoughEntity d WHERE d.type = :type", DoughEntity.class)
                    .setParameter("type", type)
                    .getSingleResult();
            if(doughEntity != null) {
                em.remove(doughEntity);
            } else {
                throw new DBException("Dough with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing dough with type: " + type, e);
        }
    }
}