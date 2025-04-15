package com.advancia.PiadineriaAdvanciaEJB.domain.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.domain.repository.PiadinaDaoService;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.PiadinaEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PiadinaServiceImpl implements PiadinaService {
	@EJB
	private PiadinaDaoService piadinaDaoService;

	@Override
	public List<PiadinaEJB> getPiadinas() {
		return piadinaDaoService.getPiadinas();
	}

	@Override
	public void addPiadina(PiadinaEJB piadina) {
		piadinaDaoService.addPiadina(piadina);
	}

	@Override
	public void removePiadina(int piadinaId) {
		piadinaDaoService.removePiadina(piadinaId);
	}
}