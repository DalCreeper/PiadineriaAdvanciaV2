package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Dough;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.MeatBase;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Sauces;
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