package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.MeatBase;
import org.mapstruct.Mapper;

@Mapper
public interface MeatBaseEJBMappers {
    MeatBase convertFromEJB(MeatBaseEJB meatBaseEJB);
    MeatBaseEJB convertToEJB(MeatBase meatBase);
}