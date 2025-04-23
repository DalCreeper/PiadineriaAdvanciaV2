package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.MeatBaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MeatBaseEntityMappers {
    MeatBaseEJB convertFromEntity(MeatBaseEntity meatBaseEntity);
    MeatBaseEntity convertToEntity(MeatBaseEJB meatBaseEJB);
}