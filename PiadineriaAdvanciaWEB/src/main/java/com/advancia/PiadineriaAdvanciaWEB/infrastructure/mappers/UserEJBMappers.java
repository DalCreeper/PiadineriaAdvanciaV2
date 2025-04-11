package com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "cdi",
    uses = {com.advancia.PiadineriaAdvanciaEJB.ejb.model.enums.RoleEJB.class, com.advancia.PiadineriaAdvanciaWEB.domain.model.enums.Role.class}
)
public interface UserEJBMappers {
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaWEB.domain.model.enums.Role.getEnumText(employeeEJB.getRoleRaw()))")
    Employee convertFromEJB(EmployeeEJB employeeEJB);
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaEJB.ejb.model.enums.RoleEJB.getEnumText(employee.getRoleRaw()))")
    EmployeeEJB convertToEJB(Employee employee);
    List<Employee> convertFromEJB(List<EmployeeEJB> employeeEJB);
    List<EmployeeEJB> convertToEJB(List<Employee> employees);
}