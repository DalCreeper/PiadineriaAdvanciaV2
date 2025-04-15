package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.DoughEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DoughEntityMappers {
    DoughEJB convertFromEntity(DoughEntity doughEntity);
    DoughEntity convertToEntity(DoughEJB doughEJB);
}