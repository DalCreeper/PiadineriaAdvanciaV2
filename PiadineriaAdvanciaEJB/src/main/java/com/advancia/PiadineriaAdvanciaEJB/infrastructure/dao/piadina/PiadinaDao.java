package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadina;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.PiadinaEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PiadinaDao {
    private static final String GET_PIADINAS = "SELECT DISTINCT p FROM PiadinaEntity p "
                                             + "JOIN FETCH p.dough "
                                             + "JOIN FETCH p.employee";

    public List<PiadinaEntity> getPiadinas(EntityManager em) {
        try {
            TypedQuery<PiadinaEntity> query = em.createQuery(GET_PIADINAS, PiadinaEntity.class);
            return query.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting piadinas from DB.", e);
        }
    }

    public void insertPiadina(EntityManager em, PiadinaEntity piadinaEntity) {
        try {
            em.merge(piadinaEntity);
        } catch(Exception e) {
            throw new DBException("Error while inserting piadina into DB.", e);
        }
    }

    public void deletePiadina(EntityManager em, int piadinaId) {
        try {
            PiadinaEntity piadinaEntity = em.find(PiadinaEntity.class, piadinaId);
            if(piadinaEntity != null) {
                piadinaEntity.getMeatBase().clear();
                piadinaEntity.getSauces().clear();
                piadinaEntity.getOptionalElements().clear();
                em.remove(piadinaEntity);
            } else {
                throw new DBException("Piadina with ID " + piadinaId + " not found.");
            }
        } catch(Exception e) {
            throw new DBException("Error while deleting piadina from DB.", e);
        }
    }
}