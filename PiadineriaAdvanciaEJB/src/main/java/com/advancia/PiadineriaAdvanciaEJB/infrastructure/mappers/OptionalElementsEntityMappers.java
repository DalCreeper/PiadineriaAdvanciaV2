package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.OptionalElementsEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OptionalElementsEntityMappers {
    OptionalElementsEJB convertFromEntity(OptionalElementsEntity optionalElementsEntity);
    OptionalElementsEntity convertToEntity(OptionalElementsEJB optionalElementsEJB);
}