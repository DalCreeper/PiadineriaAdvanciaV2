package com.advancia.PiadineriaAdvanciaEJB.domain.services;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.SaucesEJB;

import java.util.Map;
import java.util.Set;

public interface PiadinaComponentsService {
    Map<String, Set<Object>> getPiadinaComponents();
    void addDough(DoughEJB d);
    void addMeatBase(MeatBaseEJB mt);
    void addSauces(SaucesEJB s);
    void addOptionalElements(OptionalElementsEJB oe);
    DoughEJB getDoughById(int id);
    MeatBaseEJB getMeatBaseById(int id);
    SaucesEJB getSaucesById(int id);
    OptionalElementsEJB getOptionalElementsById(int id);
    void updateDough(int id, DoughEJB d);
    void updateMeatBase(int id, MeatBaseEJB mt);
    void updateSauces(int id, SaucesEJB s);
    void updateOptionalElements(int id, OptionalElementsEJB oe);
    void deleteDough(int id);
    void deleteMeatBase(int id);
    void deleteSauces(int id);
    void deleteOptionalElements(int id);
    DoughEJB getDoughByType(String type);
    MeatBaseEJB getMeatBaseByType(String type);
    SaucesEJB getSaucesByType(String type);
    OptionalElementsEJB getOptionalElementsByType(String type);
    void updateDoughByType(String type, DoughEJB d);
    void updateMeatBaseByType(String type, MeatBaseEJB mt);
    void updateSaucesByType(String type, SaucesEJB s);
    void updateOptionalElementsByType(String type, OptionalElementsEJB oe);
    void deleteDoughByType(String type);
    void deleteMeatBaseByType(String type);
    void deleteSaucesByType(String type);
    void deleteOptionalElementsByType(String type);
}