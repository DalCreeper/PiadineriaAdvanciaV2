package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.MeatBase;
import org.mapstruct.Mapper;

@Mapper
public interface MeatBaseEJBMappers {
    MeatBase convertFromEJB(MeatBaseEJB meatBaseEJB);
    MeatBaseEJB convertToEJB(MeatBase meatBase);
}