package com.advancia.PiadineriaAdvanciaWEB.domain.services.impl;

import com.advancia.PiadineriaAdvanciaWEB.domain.repository.PiadinaDaoService;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Piadina;
import com.advancia.PiadineriaAdvanciaWEB.domain.services.PiadinaService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PiadinaServiceImpl implements PiadinaService {
	@EJB
	private PiadinaDaoService piadinaDaoService;

	@Override
	public List<Piadina> getPiadinas() {
		return piadinaDaoService.getPiadinas();
	}

	@Override
	public void addPiadina(Piadina piadina) {
		piadinaDaoService.addPiadina(piadina);
	}

	@Override
	public void removePiadina(int piadinaId) {
		piadinaDaoService.removePiadina(piadinaId);
	}
}