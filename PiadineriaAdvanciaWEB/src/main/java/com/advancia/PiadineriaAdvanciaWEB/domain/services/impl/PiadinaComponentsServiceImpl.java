package com.advancia.PiadineriaAdvanciaWEB.domain.services.impl;

import com.advancia.PiadineriaAdvanciaWEB.domain.repository.PiadinaComponentsDaoService;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Dough;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.MeatBase;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Sauces;
import com.advancia.PiadineriaAdvanciaWEB.domain.services.PiadinaComponentsService;

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
	public void addDough(Dough d) {
		piadinaComponentsDaoService.addDough(d);
	}

	@Override
	public void addMeatBase(MeatBase mt) {
		piadinaComponentsDaoService.addMeatBase(mt);
	}

	@Override
	public void addSauces(Sauces s) {
		piadinaComponentsDaoService.addSauces(s);
	}

	@Override
	public void addOptionalElements(OptionalElements oe) {
		piadinaComponentsDaoService.addOptionalElements(oe);
	}

	@Override
	public Dough getDoughById(int id) {
		return piadinaComponentsDaoService.getDough(id);
	}

	@Override
	public MeatBase getMeatBaseById(int id) {
		return piadinaComponentsDaoService.getMeatBase(id);
	}

	@Override
	public Sauces getSaucesById(int id) {
		return piadinaComponentsDaoService.getSauces(id);
	}

	@Override
	public OptionalElements getOptionalElementsById(int id) {
		return piadinaComponentsDaoService.getOptionalElements(id);
	}

	@Override
	public void updateDough(int id, Dough d) {
		piadinaComponentsDaoService.updateDough(id, d);
	}

	@Override
	public void updateMeatBase(int id, MeatBase mt) {
		piadinaComponentsDaoService.updateMeatBase(id, mt);
	}

	@Override
	public void updateSauces(int id, Sauces s) {
		piadinaComponentsDaoService.updateSauces(id, s);
	}

	@Override
	public void updateOptionalElements(int id, OptionalElements oe) {
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
	public Dough getDoughByType(String type) {
		return piadinaComponentsDaoService.getDoughByType(type);
	}

	@Override
	public MeatBase getMeatBaseByType(String type) {
		return piadinaComponentsDaoService.getMeatBaseByType(type);
	}

	@Override
	public Sauces getSaucesByType(String type) {
		return piadinaComponentsDaoService.getSaucesByType(type);
	}

	@Override
	public OptionalElements getOptionalElementsByType(String type) {
		return piadinaComponentsDaoService.getOptionalElementsByType(type);
	}

	@Override
	public void updateDoughByType(String type, Dough d) {
		piadinaComponentsDaoService.updateDoughByType(type, d);
	}

	@Override
	public void updateMeatBaseByType(String type, MeatBase mt) {
		piadinaComponentsDaoService.updateMeatBaseByType(type, mt);
	}

	@Override
	public void updateSaucesByType(String type, Sauces s) {
		piadinaComponentsDaoService.updateSaucesByType(type, s);
	}

	@Override
	public void updateOptionalElementsByType(String type, OptionalElements oe) {
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