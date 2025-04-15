package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.MeatBaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MeatBaseEntityMappers {
    MeatBaseEJB convertFromEntity(MeatBaseEntity meatBaseEntity);
    MeatBaseEntity convertToEntity(MeatBaseEJB meatBaseEJB);
}