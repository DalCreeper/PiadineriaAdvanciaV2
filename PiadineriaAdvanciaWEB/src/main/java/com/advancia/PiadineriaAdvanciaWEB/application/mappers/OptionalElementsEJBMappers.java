package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.OptionalElements;
import org.mapstruct.Mapper;

@Mapper
public interface OptionalElementsEJBMappers {
    OptionalElements convertFromEJB(OptionalElementsEJB optionalElementsEJB);
    OptionalElementsEJB convertToEJB(OptionalElements optionalElements);
}