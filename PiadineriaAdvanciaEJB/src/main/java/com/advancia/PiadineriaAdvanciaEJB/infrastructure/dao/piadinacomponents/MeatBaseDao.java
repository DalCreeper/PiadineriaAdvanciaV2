package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.MeatBaseEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class MeatBaseDao {
    private static final String GET_MEAT_BASE_BY_ID = "SELECT m FROM MeatBaseEntity m WHERE m.id = :id";
    private static final String GET_MEATBASE_BY_TYPE = "SELECT m FROM MeatBaseEntity m WHERE m.type = :type";

    public MeatBaseEntity get(int id, EntityManager em) {
        try {
            return em.createQuery(GET_MEAT_BASE_BY_ID, MeatBaseEntity.class).setParameter("id", id).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base with ID: " + id, e);
        }
    }

    public MeatBaseEntity getByType(String type, EntityManager em) {
        try {
            return em.createQuery(GET_MEATBASE_BY_TYPE, MeatBaseEntity.class).setParameter("type", type).getSingleResult();
        } catch(Exception e) {
            throw new DBException("Error while retrieving meatBase with type: " + type, e);
        }
    }

    public void add(MeatBaseEntity mt, EntityManager em) {
        try {
            em.persist(mt);
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }

    public void update(int id, MeatBaseEntity mt, EntityManager em) {
        try {
            MeatBaseEntity existingMeatBaseEntity = em.find(MeatBaseEntity.class, id);
            if(existingMeatBaseEntity != null) {
                existingMeatBaseEntity.setType(mt.getType());
                existingMeatBaseEntity.setDescription(mt.getDescription());
                existingMeatBaseEntity.setPrice(mt.getPrice());
                em.merge(existingMeatBaseEntity);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with ID: " + id, e);
        }
    }

    public void updateByType(String type, MeatBaseEntity mt, EntityManager em) {
        try {
            MeatBaseEntity existingMeatBaseEntity = em.createQuery("SELECT mt FROM MeatBaseEntity mt WHERE mt.type = :type", MeatBaseEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(existingMeatBaseEntity != null) {
                existingMeatBaseEntity.setType(mt.getType());
                existingMeatBaseEntity.setDescription(mt.getDescription());
                existingMeatBaseEntity.setPrice(mt.getPrice());
                em.merge(existingMeatBaseEntity);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while updating meat base with type: " + type, e);
        }
    }

    public void remove(int id, EntityManager em) {
        try {
            MeatBaseEntity meatBaseEntity = em.find(MeatBaseEntity.class, id);
            if(meatBaseEntity != null) {
                em.remove(meatBaseEntity);
            } else {
                throw new DBException("MeatBase with ID " + id + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meat base with ID: " + id, e);
        }
    }

    public void removeByType(String type, EntityManager em) {
        try {
            MeatBaseEntity meatBaseEntity = em.createQuery("SELECT m FROM MeatBaseEntity m WHERE m.type = :type", MeatBaseEntity.class)
                .setParameter("type", type)
                .getSingleResult();
            if(meatBaseEntity != null) {
                em.remove(meatBaseEntity);
            } else {
                throw new DBException("MeatBase with type " + type + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while removing meatBase with type: " + type, e);
        }
    }
}