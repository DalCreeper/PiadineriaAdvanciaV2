package com.advancia.PiadineriaAdvanciaEJB.domain.repository;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;

import java.util.Map;
import java.util.Set;

public interface PiadinaComponentsDaoService {
    Map<String, Set<Object>> getAllComponents();
    void addDough(DoughEJB d);
    void addMeatBase(MeatBaseEJB mt);
    void addSauces(SaucesEJB s);
    void addOptionalElements(OptionalElementsEJB oe);
    DoughEJB getDough(int id);
    MeatBaseEJB getMeatBase(int id);
    SaucesEJB getSauces(int id);
    OptionalElementsEJB getOptionalElements(int id);
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