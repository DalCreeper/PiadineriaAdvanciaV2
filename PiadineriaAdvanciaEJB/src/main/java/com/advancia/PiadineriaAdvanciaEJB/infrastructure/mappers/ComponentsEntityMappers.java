package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.DoughEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.MeatBaseEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.OptionalElementsEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.SaucesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ComponentsEntityMappers {
    DoughEJB convertFromEntity(DoughEntity doughEntity);
    DoughEntity convertToEntity(DoughEJB doughEJB);

    MeatBaseEJB convertFromEntity(MeatBaseEntity meatBaseEntity);
    MeatBaseEntity convertToEntity(MeatBaseEJB meatBaseEJB);

    SaucesEJB convertFromEntity(SaucesEntity saucesEntity);
    SaucesEntity convertToEntity(SaucesEJB saucesEJB);

    OptionalElementsEJB convertFromEntity(OptionalElementsEntity optionalElementsEntity);
    OptionalElementsEntity convertToEntity(OptionalElementsEJB optionalElementsEJB);
}