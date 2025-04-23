package com.advancia.PiadineriaAdvanciaEJB.domain.repository;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;

import java.util.List;

public interface EmployeeDaoService {
    EmployeeEJB getEmployee(String username, String password);
    List<EmployeeEJB> getEmployees();
    EmployeeEJB getEmployee(int UID);
    void createEmployee(EmployeeEJB employee);
    void updateEmployee(int UID, EmployeeEJB emUpdated);
    void deleteEmployee(int UID);
}