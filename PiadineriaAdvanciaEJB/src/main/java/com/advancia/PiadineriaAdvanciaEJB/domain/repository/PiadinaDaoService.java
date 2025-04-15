package com.advancia.PiadineriaAdvanciaEJB.domain.repository;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.PiadinaEJB;

import java.util.List;

public interface PiadinaDaoService {
    List<PiadinaEJB> getPiadinas();
    void addPiadina(PiadinaEJB piadina);
    void removePiadina(int piadinaId);
}