package com.advancia.PiadineriaAdvanciaWEB.infrastructure.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.PiadinaEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.repository.PiadinaDaoService;
import com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina.AddPiadinaDao;
import com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina.GetPiadinasDao;
import com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadina.RemovePiadinaDao;
import com.advancia.PiadineriaAdvanciaWEB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Piadina;
import com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers.PiadinaEJBMappers;
import org.mapstruct.factory.Mappers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PiadinaDaoServiceImpl implements PiadinaDaoService {
	@PersistenceContext
	private EntityManager em;
	private final PiadinaEJBMappers piadinaEJBMappers = Mappers.getMapper(PiadinaEJBMappers.class);
	private final GetPiadinasDao getPiadinasDao = new GetPiadinasDao();
	private final AddPiadinaDao addPiadinaDao = new AddPiadinaDao();
	private final RemovePiadinaDao removePiadinaDao = new RemovePiadinaDao();

	@Override
	public List<Piadina> getPiadinas() {
		try {
			List<PiadinaEJB> piadinasEJB = getPiadinasDao.getPiadinas(em);
            return piadinaEJBMappers.convertFromEJB(piadinasEJB);
		} catch(Exception e) {
            throw new DBException("Error while retrieving piadinas.", e);
        }
	}

	@Override
	public void addPiadina(Piadina piadina) {
		try {
			PiadinaEJB piadinaEJB = piadinaEJBMappers.convertToEJB(piadina);
			addPiadinaDao.insertPiadina(em, piadinaEJB);
		} catch(Exception e) {
            throw new DBException("Error while adding piadina.", e);
        }
	}

	@Override
	public void removePiadina(int piadinaId) {
		try {
			removePiadinaDao.deletePiadina(em, piadinaId);
		} catch(Exception e) {
            throw new DBException("Error while removing piadina.", e);
        }
	}
}