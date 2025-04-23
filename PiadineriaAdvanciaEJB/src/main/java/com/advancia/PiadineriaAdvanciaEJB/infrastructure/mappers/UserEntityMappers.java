package com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.enums.RoleEJB;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.EmployeeEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.enums.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "cdi",
    uses = {RoleEJB.class, RoleEntity.class}
)
public interface UserEntityMappers {
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaEJB.domain.model.enums.RoleEJB.getEnumText(employeeEJB.getRoleRaw()))")
    EmployeeEJB convertFromEntity(EmployeeEntity employeeEntity);
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.enums.RoleEntity.getEnumText(employeeEntity.getRoleRaw()))")
    EmployeeEntity convertToEntity(EmployeeEJB employeeEJB);

    List<EmployeeEJB> convertFromEntity(List<EmployeeEntity> employeesEntity);
    List<EmployeeEntity> convertToEntity(List<EmployeeEJB> employeesEJB);
}