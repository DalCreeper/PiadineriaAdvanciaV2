package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaDeserializeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.PiadinaEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.PiadinaDeserializeEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.PiadinaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "cdi",
    uses = {DoughEntityMappers.class, MeatBaseEntityMappers.class, SaucesEntityMappers.class, OptionalElementsEntityMappers.class, UserEntityMappers.class}
)
public interface PiadinaEntityMappers {
    @Mapping(source = "dough", target = "dough")
    @Mapping(source = "meatBase", target = "meatBase")
    @Mapping(source = "sauces", target = "sauces")
    @Mapping(source = "optionalElements", target = "optionalElements")
    @Mapping(source = "employee", target = "employee")
    PiadinaEJB convertFromEntity(PiadinaEntity piadinaEntity);
    @Mapping(source = "dough", target = "dough")
    @Mapping(source = "meatBase", target = "meatBase")
    @Mapping(source = "sauces", target = "sauces")
    @Mapping(source = "optionalElements", target = "optionalElements")
    @Mapping(source = "employee", target = "employee")
    PiadinaEntity convertToEntity(PiadinaEJB piadinaEJB);

    List<PiadinaEJB> convertFromEntity(List<PiadinaEntity> piadinasEntity);
    List<PiadinaEntity> convertToEntity(List<PiadinaEJB> piadinasEJB);

    PiadinaDeserializeEJB convertFromEntity(PiadinaDeserializeEntity piadinaDeserializeEntity);
    PiadinaDeserializeEntity convertToEntity(PiadinaDeserializeEJB piadinaDeserializeEJB);
}