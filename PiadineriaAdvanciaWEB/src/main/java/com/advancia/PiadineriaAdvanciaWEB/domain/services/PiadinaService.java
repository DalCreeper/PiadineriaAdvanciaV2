package com.advancia.PiadineriaAdvanciaWEB.domain.services;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Piadina;

import java.util.List;

public interface PiadinaService {
    List<Piadina> getPiadinas();
    void addPiadina(Piadina piadina);
    void removePiadina(int piadinaId);
}