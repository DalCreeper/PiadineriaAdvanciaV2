package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.SaucesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SaucesEntityMappers {
    SaucesEJB convertFromEntity(SaucesEntity saucesEntity);
    SaucesEntity convertToEntity(SaucesEJB SaucesEJB);
}