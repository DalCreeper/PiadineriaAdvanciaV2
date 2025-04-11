package com.advancia.PiadineriaAdvanciaWEB.domain.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.advancia.PiadineriaAdvanciaWEB.domain.repository.EmployeeDaoService;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Employee;
import com.advancia.PiadineriaAdvanciaWEB.domain.services.UserService;

@Stateless
public class UserServiceImpl implements UserService {
    @EJB
    private EmployeeDaoService employeeDaoService;

    @Override
    public Employee getUser(String username, String password) {
        return employeeDaoService.getEmployee(username, password);
    }

    @Override
    public List<Employee> getUsers() {
        return employeeDaoService.getEmployees();
    }

    @Override
    public Employee getUserByID(int UID) {
        return employeeDaoService.getEmployee(UID);
    }

    @Override
    public void createUser(Employee em) {
        employeeDaoService.createEmployee(em);
    }

    @Override
    public void updateUser(int UID, Employee emUpdated) {
        employeeDaoService.updateEmployee(UID, emUpdated);
    }

    @Override
    public void deleteUser(int UID) {
        employeeDaoService.deleteEmployee(UID);
    }
}