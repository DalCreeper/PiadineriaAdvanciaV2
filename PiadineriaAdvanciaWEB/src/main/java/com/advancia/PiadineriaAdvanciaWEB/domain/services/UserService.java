package com.advancia.PiadineriaAdvanciaWEB.domain.services;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Employee;

import java.util.List;

public interface UserService {
    Employee getUser(String username, String password);
    List<Employee> getUsers();
    Employee getUserByID(int UID);
    void createUser(Employee em);
    void updateUser(int UID, Employee emUpdated);
    void deleteUser(int UID);
}