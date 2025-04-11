package com.advancia.PiadineriaAdvanciaWEB.domain.repository;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Employee;

import java.util.List;

public interface EmployeeDaoService {
    Employee getEmployee(String username, String password);
    List<Employee> getEmployees();
    Employee getEmployee(int UID);
    void createEmployee(Employee employee);
    void updateEmployee(int UID, Employee emUpdated);
    void deleteEmployee(int UID);
}