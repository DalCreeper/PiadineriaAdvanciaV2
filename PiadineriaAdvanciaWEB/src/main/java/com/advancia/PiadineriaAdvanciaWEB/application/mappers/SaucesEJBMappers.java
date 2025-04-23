package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Sauces;
import org.mapstruct.Mapper;

@Mapper
public interface SaucesEJBMappers {
    Sauces convertFromEJB(SaucesEJB saucesEJB);
    SaucesEJB convertToEJB(Sauces sauces);
}