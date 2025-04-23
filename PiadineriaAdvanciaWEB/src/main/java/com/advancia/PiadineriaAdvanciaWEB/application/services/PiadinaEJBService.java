package com.advancia.PiadineriaAdvanciaWEB.application.services;

import com.advancia.PiadineriaAdvanciaWEB.application.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PiadinaEJBService {
    List<Piadina> getPiadinas();
    void addPiadina(Piadina piadina);
    void removePiadina(int piadinaId);
    /* -------------------------------------------------------------------------------------------------------------- */
    Map<String, Set<Object>> getPiadinaComponents();
    void addDough(Dough d);
    void addMeatBase(MeatBase mt);
    void addSauces(Sauces s);
    void addOptionalElements(OptionalElements oe);
    Dough getDoughById(int id);
    MeatBase getMeatBaseById(int id);
    Sauces getSaucesById(int id);
    OptionalElements getOptionalElementsById(int id);
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