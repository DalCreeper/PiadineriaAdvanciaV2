package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.SaucesEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.DoughEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.MeatBaseEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.OptionalElementsEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.SaucesEntity;
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