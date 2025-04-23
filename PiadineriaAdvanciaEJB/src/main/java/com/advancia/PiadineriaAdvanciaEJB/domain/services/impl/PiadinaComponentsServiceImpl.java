package com.advancia.PiadineriaAdvanciaEJB.domain.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.domain.repository.PiadinaComponentsDaoService;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaComponentsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Map;
import java.util.Set;

@Stateless
public class PiadinaComponentsServiceImpl implements PiadinaComponentsService {
	@EJB
	private PiadinaComponentsDaoService piadinaComponentsDaoService;

	@Override
	public Map<String, Set<Object>> getPiadinaComponents() {
		return piadinaComponentsDaoService.getAllComponents();
	}

	@Override
	public void addDough(DoughEJB d) {
		piadinaComponentsDaoService.addDough(d);
	}

	@Override
	public void addMeatBase(MeatBaseEJB mt) {
		piadinaComponentsDaoService.addMeatBase(mt);
	}

	@Override
	public void addSauces(SaucesEJB s) {
		piadinaComponentsDaoService.addSauces(s);
	}

	@Override
	public void addOptionalElements(OptionalElementsEJB oe) {
		piadinaComponentsDaoService.addOptionalElements(oe);
	}

	@Override
	public DoughEJB getDoughById(int id) {
		return piadinaComponentsDaoService.getDough(id);
	}

	@Override
	public MeatBaseEJB getMeatBaseById(int id) {
		return piadinaComponentsDaoService.getMeatBase(id);
	}

	@Override
	public SaucesEJB getSaucesById(int id) {
		return piadinaComponentsDaoService.getSauces(id);
	}

	@Override
	public OptionalElementsEJB getOptionalElementsById(int id) {
		return piadinaComponentsDaoService.getOptionalElements(id);
	}

	@Override
	public void updateDough(int id, DoughEJB d) {
		piadinaComponentsDaoService.updateDough(id, d);
	}

	@Override
	public void updateMeatBase(int id, MeatBaseEJB mt) {
		piadinaComponentsDaoService.updateMeatBase(id, mt);
	}

	@Override
	public void updateSauces(int id, SaucesEJB s) {
		piadinaComponentsDaoService.updateSauces(id, s);
	}

	@Override
	public void updateOptionalElements(int id, OptionalElementsEJB oe) {
		piadinaComponentsDaoService.updateOptionalElements(id, oe);
	}

	@Override
	public void deleteDough(int id) {
		piadinaComponentsDaoService.deleteDough(id);
	}

	@Override
	public void deleteMeatBase(int id) {
		piadinaComponentsDaoService.deleteMeatBase(id);
	}

	@Override
	public void deleteSauces(int id) {
		piadinaComponentsDaoService.deleteSauces(id);
	}

	@Override
	public void deleteOptionalElements(int id) {
		piadinaComponentsDaoService.deleteOptionalElements(id);
	}

	@Override
	public DoughEJB getDoughByType(String type) {
		return piadinaComponentsDaoService.getDoughByType(type);
	}

	@Override
	public MeatBaseEJB getMeatBaseByType(String type) {
		return piadinaComponentsDaoService.getMeatBaseByType(type);
	}

	@Override
	public SaucesEJB getSaucesByType(String type) {
		return piadinaComponentsDaoService.getSaucesByType(type);
	}

	@Override
	public OptionalElementsEJB getOptionalElementsByType(String type) {
		return piadinaComponentsDaoService.getOptionalElementsByType(type);
	}

	@Override
	public void updateDoughByType(String type, DoughEJB d) {
		piadinaComponentsDaoService.updateDoughByType(type, d);
	}

	@Override
	public void updateMeatBaseByType(String type, MeatBaseEJB mt) {
		piadinaComponentsDaoService.updateMeatBaseByType(type, mt);
	}

	@Override
	public void updateSaucesByType(String type, SaucesEJB s) {
		piadinaComponentsDaoService.updateSaucesByType(type, s);
	}

	@Override
	public void updateOptionalElementsByType(String type, OptionalElementsEJB oe) {
		piadinaComponentsDaoService.updateOptionalElementsByType(type, oe);
	}

	@Override
	public void deleteDoughByType(String type) {
		piadinaComponentsDaoService.deleteDoughByType(type);
	}

	@Override
	public void deleteMeatBaseByType(String type) {
		piadinaComponentsDaoService.deleteMeatBaseByType(type);
	}

	@Override
	public void deleteSaucesByType(String type) {
		piadinaComponentsDaoService.deleteSaucesByType(type);
	}

	@Override
	public void deleteOptionalElementsByType(String type) {
		piadinaComponentsDaoService.deleteOptionalElementsByType(type);
	}
}