package com.advancia.PiadineriaAdvanciaWEB.application.services;

import com.advancia.PiadineriaAdvanciaWEB.application.model.Employee;

import java.util.List;

public interface UserEJBService {
    Employee getUser(String username, String password);
    List<Employee> getUsers();
    Employee getUserByID(int UID);
    void createUser(Employee em);
    void updateUser(int UID, Employee emUpdated);
    void deleteUser(int UID);
}