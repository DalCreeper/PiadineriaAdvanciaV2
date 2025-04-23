package com.advancia.PiadineriaAdvanciaEJB.infrastructure.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadina.PiadinaDao;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.repository.PiadinaDaoService;
import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers.PiadinaEntityMappers;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.PiadinaEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PiadinaDaoServiceImpl implements PiadinaDaoService {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private PiadinaEntityMappers piadinaEntityMappers;
	private final PiadinaDao piadinaDao = new PiadinaDao();

	@Override
	public List<PiadinaEJB> getPiadinas() {
		try {
			List<PiadinaEntity> piadinasEntity = piadinaDao.getPiadinas(em);
            return piadinaEntityMappers.convertFromEntity(piadinasEntity);
		} catch(Exception e) {
            throw new DBException("Error while retrieving piadinas.", e);
        }
	}

	@Override
	public void addPiadina(PiadinaEJB piadinaEJB) {
		try {
			PiadinaEntity piadinaEntity = piadinaEntityMappers.convertToEntity(piadinaEJB);
			piadinaDao.insertPiadina(em, piadinaEntity);
		} catch(Exception e) {
            throw new DBException("Error while adding piadina.", e);
        }
	}

	@Override
	public void removePiadina(int piadinaId) {
		try {
			piadinaDao.deletePiadina(em, piadinaId);
		} catch(Exception e) {
            throw new DBException("Error while removing piadina.", e);
        }
	}
}