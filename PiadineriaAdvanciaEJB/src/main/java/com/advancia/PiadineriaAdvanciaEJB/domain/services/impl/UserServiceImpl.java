package com.advancia.PiadineriaAdvanciaEJB.domain.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.advancia.PiadineriaAdvanciaEJB.domain.repository.EmployeeDaoService;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.UserService;

@Stateless
public class UserServiceImpl implements UserService {
    @EJB
    private EmployeeDaoService employeeDaoService;

    @Override
    public EmployeeEJB getUser(String username, String password) {
        return employeeDaoService.getEmployee(username, password);
    }

    @Override
    public List<EmployeeEJB> getUsers() {
        return employeeDaoService.getEmployees();
    }

    @Override
    public EmployeeEJB getUserByID(int UID) {
        return employeeDaoService.getEmployee(UID);
    }

    @Override
    public void createUser(EmployeeEJB em) {
        employeeDaoService.createEmployee(em);
    }

    @Override
    public void updateUser(int UID, EmployeeEJB emUpdated) {
        employeeDaoService.updateEmployee(UID, emUpdated);
    }

    @Override
    public void deleteUser(int UID) {
        employeeDaoService.deleteEmployee(UID);
    }
}