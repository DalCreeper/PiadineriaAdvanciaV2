package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Dough;
import org.mapstruct.Mapper;

@Mapper
public interface DoughEJBMappers {
    Dough convertFromEJB(DoughEJB doughEJB);
    DoughEJB convertToEJB(Dough dough);
}