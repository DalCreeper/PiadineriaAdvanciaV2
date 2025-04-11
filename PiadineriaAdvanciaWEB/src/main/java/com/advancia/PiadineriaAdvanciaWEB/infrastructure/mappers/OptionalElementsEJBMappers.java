package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.OptionalElements;
import org.mapstruct.Mapper;

@Mapper
public interface OptionalElementsEJBMappers {
    OptionalElements convertFromEJB(OptionalElementsEJB optionalElementsEJB);
    OptionalElementsEJB convertToEJB(OptionalElements optionalElements);
}