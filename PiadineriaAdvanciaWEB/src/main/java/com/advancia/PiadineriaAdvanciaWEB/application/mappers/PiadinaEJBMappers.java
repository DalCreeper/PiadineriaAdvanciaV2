package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaDeserializeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Piadina;
import com.advancia.PiadineriaAdvanciaWEB.application.model.PiadinaDeserialize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "cdi",
    uses = { DoughEJBMappers.class, MeatBaseEJBMappers.class, SaucesEJBMappers.class, OptionalElementsEJBMappers.class, UserEJBMappers.class }
)
public interface PiadinaEJBMappers {
    @Mapping(source = "dough", target = "dough")
    @Mapping(source = "meatBase", target = "meatBase")
    @Mapping(source = "sauces", target = "sauces")
    @Mapping(source = "optionalElements", target = "optionalElements")
    @Mapping(source = "employee", target = "employee")
    Piadina convertFromEJB(PiadinaEJB piadinaEJB);
    @Mapping(source = "dough", target = "dough")
    @Mapping(source = "meatBase", target = "meatBase")
    @Mapping(source = "sauces", target = "sauces")
    @Mapping(source = "optionalElements", target = "optionalElements")
    @Mapping(source = "employee", target = "employee")
    PiadinaEJB convertToEJB(Piadina piadina);
    List<Piadina> convertFromEJB(List<PiadinaEJB> piadinasEJB);
    List<PiadinaEJB> convertToEJB(List<Piadina> piadinas);
    PiadinaDeserialize convertFromEJB(PiadinaDeserializeEJB piadinaDeserializeEJB);
    PiadinaDeserializeEJB convertToEJB(PiadinaDeserialize piadinaDeserialize);
}