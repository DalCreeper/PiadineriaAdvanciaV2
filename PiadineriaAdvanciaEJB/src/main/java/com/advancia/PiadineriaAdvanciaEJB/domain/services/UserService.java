package com.advancia.PiadineriaAdvanciaEJB.domain.services;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;

import java.util.List;

public interface UserService {
    EmployeeEJB getUser(String username, String password);
    List<EmployeeEJB> getUsers();
    EmployeeEJB getUserByID(int UID);
    void createUser(EmployeeEJB em);
    void updateUser(int UID, EmployeeEJB emUpdated);
    void deleteUser(int UID);
}