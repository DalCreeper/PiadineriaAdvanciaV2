package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Dough;
import org.mapstruct.Mapper;

@Mapper
public interface DoughEJBMappers {
    Dough convertFromEJB(DoughEJB doughEJB);
    DoughEJB convertToEJB(Dough dough);
}