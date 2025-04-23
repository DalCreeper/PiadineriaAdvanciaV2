package com.advancia.PiadineriaAdvanciaWEB.application.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.*;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaComponentsService;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaService;
import com.advancia.PiadineriaAdvanciaWEB.application.mappers.ComponentsEJBMappers;
import com.advancia.PiadineriaAdvanciaWEB.application.mappers.PiadinaEJBMappers;
import com.advancia.PiadineriaAdvanciaWEB.application.model.*;
import com.advancia.PiadineriaAdvanciaWEB.application.services.PiadinaEJBService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Stateless
public class PiadinaEJBServiceImpl implements PiadinaEJBService {
    @EJB
    private PiadinaComponentsService piadinaComponentsService;
    @EJB
    private PiadinaService piadinaService;
    @Inject
    private PiadinaEJBMappers piadinaEJBMappers;
    @Inject
    private ComponentsEJBMappers componentsEJBMappers;

    @Override
    public List<Piadina> getPiadinas() {
        List<PiadinaEJB> piadinasEJB = piadinaService.getPiadinas();
        return piadinaEJBMappers.convertFromEJB(piadinasEJB);
    }

    @Override
    public void addPiadina(Piadina piadina) {
        PiadinaEJB piadinaEJB = piadinaEJBMappers.convertToEJB(piadina);
        piadinaService.addPiadina(piadinaEJB);
    }

    @Override
    public void removePiadina(int piadinaId) {
        piadinaService.removePiadina(piadinaId);
    }

    @Override
    public Map<String, Set<Object>> getPiadinaComponents() {
        return piadinaComponentsService.getPiadinaComponents();
    }

    @Override
    public void addDough(Dough d) {
        DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
        piadinaComponentsService.addDough(doughEJB);
    }

    @Override
    public void addMeatBase(MeatBase mt) {
        MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
        piadinaComponentsService.addMeatBase(meatBaseEJB);
    }

    @Override
    public void addSauces(Sauces s) {
        SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
        piadinaComponentsService.addSauces(saucesEJB);
    }

    @Override
    public void addOptionalElements(OptionalElements oe) {
        OptionalElementsEJB pojoEJB = componentsEJBMappers.convertToEJB(oe);
        piadinaComponentsService.addOptionalElements(pojoEJB);
    }

    @Override
    public Dough getDoughById(int id) {
        DoughEJB doughEJB = piadinaComponentsService.getDoughById(id);
        return componentsEJBMappers.convertFromEJB(doughEJB);
    }

    @Override
    public MeatBase getMeatBaseById(int id) {
        MeatBaseEJB meatBaseEJB = piadinaComponentsService.getMeatBaseById(id);
        return componentsEJBMappers.convertFromEJB(meatBaseEJB);
    }

    @Override
    public Sauces getSaucesById(int id) {
        SaucesEJB saucesEJB = piadinaComponentsService.getSaucesById(id);
        return componentsEJBMappers.convertFromEJB(saucesEJB);
    }

    @Override
    public OptionalElements getOptionalElementsById(int id) {
        OptionalElementsEJB pojoEJB = piadinaComponentsService.getOptionalElementsById(id);
        return componentsEJBMappers.convertFromEJB(pojoEJB);
    }

    @Override
    public void updateDough(int id, Dough d) {
        DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
        piadinaComponentsService.updateDough(id, doughEJB);
    }

    @Override
    public void updateMeatBase(int id, MeatBase mt) {
        MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
        piadinaComponentsService.updateMeatBase(id, meatBaseEJB);
    }

    @Override
    public void updateSauces(int id, Sauces s) {
        SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
        piadinaComponentsService.updateSauces(id, saucesEJB);
    }

    @Override
    public void updateOptionalElements(int id, OptionalElements oe) {
        OptionalElementsEJB pojoEJB = piadinaComponentsService.getOptionalElementsById(id);
        piadinaComponentsService.updateOptionalElements(id, pojoEJB);
    }

    @Override
    public void deleteDough(int id) {
        piadinaComponentsService.deleteDough(id);
    }

    @Override
    public void deleteMeatBase(int id) {
        piadinaComponentsService.deleteMeatBase(id);
    }

    @Override
    public void deleteSauces(int id) {
        piadinaComponentsService.deleteSauces(id);
    }

    @Override
    public void deleteOptionalElements(int id) {
        piadinaComponentsService.deleteOptionalElements(id);
    }

    @Override
    public Dough getDoughByType(String type) {
        DoughEJB doughEJB = piadinaComponentsService.getDoughByType(type);
        return componentsEJBMappers.convertFromEJB(doughEJB);
    }

    @Override
    public MeatBase getMeatBaseByType(String type) {
        MeatBaseEJB meatBaseEJB = piadinaComponentsService.getMeatBaseByType(type);
        return componentsEJBMappers.convertFromEJB(meatBaseEJB);
    }

    @Override
    public Sauces getSaucesByType(String type) {
        SaucesEJB saucesEJB = piadinaComponentsService.getSaucesByType(type);
        return componentsEJBMappers.convertFromEJB(saucesEJB);
    }

    @Override
    public OptionalElements getOptionalElementsByType(String type) {
        OptionalElementsEJB optionalElementsEJB = piadinaComponentsService.getOptionalElementsByType(type);
        return componentsEJBMappers.convertFromEJB(optionalElementsEJB);
    }

    @Override
    public void updateDoughByType(String type, Dough d) {
        DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
        piadinaComponentsService.updateDoughByType(type, doughEJB);
    }

    @Override
    public void updateMeatBaseByType(String type, MeatBase mt) {
        MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
        piadinaComponentsService.updateMeatBaseByType(type, meatBaseEJB);
    }

    @Override
    public void updateSaucesByType(String type, Sauces s) {
        SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
        piadinaComponentsService.updateSaucesByType(type, saucesEJB);
    }

    @Override
    public void updateOptionalElementsByType(String type, OptionalElements oe) {
        OptionalElementsEJB optionalElementsEJB = piadinaComponentsService.getOptionalElementsByType(type);
        piadinaComponentsService.updateOptionalElementsByType(type, optionalElementsEJB);
    }

    @Override
    public void deleteDoughByType(String type) {
        piadinaComponentsService.deleteDoughByType(type);
    }

    @Override
    public void deleteMeatBaseByType(String type) {
        piadinaComponentsService.deleteMeatBaseByType(type);
    }

    @Override
    public void deleteSaucesByType(String type) {
        piadinaComponentsService.deleteSaucesByType(type);
    }

    @Override
    public void deleteOptionalElementsByType(String type) {
        piadinaComponentsService.deleteOptionalElementsByType(type);
    }
}