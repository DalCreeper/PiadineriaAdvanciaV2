package com.advancia.PiadineriaAdvanciaWEB.domain.repository;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Piadina;

import java.util.List;

public interface PiadinaDaoService {
    List<Piadina> getPiadinas();
    void addPiadina(Piadina piadina);
    void removePiadina(int piadinaId);
}