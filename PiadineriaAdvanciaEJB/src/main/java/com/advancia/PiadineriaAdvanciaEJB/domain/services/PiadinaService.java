package com.advancia.PiadineriaAdvanciaEJB.domain.services;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaEJB;

import java.util.List;

public interface PiadinaService {
    List<PiadinaEJB> getPiadinas();
    void addPiadina(PiadinaEJB piadina);
    void removePiadina(int piadinaId);
}