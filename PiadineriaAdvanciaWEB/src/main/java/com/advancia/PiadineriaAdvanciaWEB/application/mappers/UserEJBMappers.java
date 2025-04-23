package com.advancia.PiadineriaAdvanciaWEB.application.mappers;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.enums.RoleEJB;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Employee;
import com.advancia.PiadineriaAdvanciaWEB.application.model.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "cdi",
    uses = { RoleEJB.class, Role.class }
)
public interface UserEJBMappers {
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaWEB.application.model.enums.Role.getEnumText(employeeEJB.getRoleRaw()))")
    Employee convertFromEJB(EmployeeEJB employeeEJB);
    @Mapping(target = "role", expression = "java(com.advancia.PiadineriaAdvanciaEJB.domain.model.enums.RoleEJB.getEnumText(employee.getRoleRaw()))")
    EmployeeEJB convertToEJB(Employee employee);
    List<Employee> convertFromEJB(List<EmployeeEJB> employeeEJB);
    List<EmployeeEJB> convertToEJB(List<Employee> employees);
}