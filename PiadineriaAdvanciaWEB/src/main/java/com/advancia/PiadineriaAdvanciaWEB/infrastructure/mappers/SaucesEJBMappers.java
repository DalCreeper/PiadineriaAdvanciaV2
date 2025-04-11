package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Sauces;
import org.mapstruct.Mapper;

@Mapper
public interface SaucesEJBMappers {
    Sauces convertFromEJB(SaucesEJB saucesEJB);
    SaucesEJB convertToEJB(Sauces sauces);
}