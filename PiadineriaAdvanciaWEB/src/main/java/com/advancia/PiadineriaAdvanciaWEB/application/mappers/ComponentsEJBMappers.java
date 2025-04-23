package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Dough;
import com.advancia.PiadineriaAdvanciaWEB.application.model.MeatBase;
import com.advancia.PiadineriaAdvanciaWEB.application.model.OptionalElements;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Sauces;
import org.mapstruct.Mapper;

@Mapper
public interface ComponentsEJBMappers {
    Dough convertFromEJB(DoughEJB doughEJB);
    DoughEJB convertToEJB(Dough dough);
    MeatBase convertFromEJB(MeatBaseEJB meatBaseEJB);
    MeatBaseEJB convertToEJB(MeatBase meatBase);
    Sauces convertFromEJB(SaucesEJB saucesEJB);
    SaucesEJB convertToEJB(Sauces sauces);
    OptionalElements convertFromEJB(OptionalElementsEJB optionalElementsEJB);
    OptionalElementsEJB convertToEJB(OptionalElements optionalElements);
}