package com.advancia.PiadineriaAdvanciaWEB.domain.repository;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Dough;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.MeatBase;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Sauces;

import java.util.Map;
import java.util.Set;

public interface PiadinaComponentsDaoService {
    Map<String, Set<Object>> getAllComponents();
    void addDough(Dough d);
    void addMeatBase(MeatBase mt);
    void addSauces(Sauces s);
    void addOptionalElements(OptionalElements oe);
    Dough getDough(int id);
    MeatBase getMeatBase(int id);
    Sauces getSauces(int id);
    OptionalElements getOptionalElements(int id);
    void updateDough(int id, Dough d);
    void updateMeatBase(int id, MeatBase mt);
    void updateSauces(int id, Sauces s);
    void updateOptionalElements(int id, OptionalElements oe);
    void deleteDough(int id);
    void deleteMeatBase(int id);
    void deleteSauces(int id);
    void deleteOptionalElements(int id);
    Dough getDoughByType(String type);
    MeatBase getMeatBaseByType(String type);
    Sauces getSaucesByType(String type);
    OptionalElements getOptionalElementsByType(String type);
    void updateDoughByType(String type, Dough d);
    void updateMeatBaseByType(String type, MeatBase mt);
    void updateSaucesByType(String type, Sauces s);
    void updateOptionalElementsByType(String type, OptionalElements oe);
    void deleteDoughByType(String type);
    void deleteMeatBaseByType(String type);
    void deleteSaucesByType(String type);
    void deleteOptionalElementsByType(String type);
}