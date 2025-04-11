package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.PiadinaEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GetPiadinasDao {
	private static final String GET_PIADINAS = "SELECT DISTINCT p FROM PiadinaEJB p "
											 + "JOIN FETCH p.dough "
											 + "JOIN FETCH p.employee";
	public List<PiadinaEJB> getPiadinas(EntityManager em) {
        try {
		    TypedQuery<PiadinaEJB> query = em.createQuery(GET_PIADINAS, PiadinaEJB.class);
            return query.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting piadinas from DB.", e);
        }
    }
}