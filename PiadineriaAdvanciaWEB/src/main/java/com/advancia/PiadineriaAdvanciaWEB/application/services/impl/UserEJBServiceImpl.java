package com.advancia.PiadineriaAdvanciaWEB.application.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.UserService;
import com.advancia.PiadineriaAdvanciaWEB.application.mappers.UserEJBMappers;
import com.advancia.PiadineriaAdvanciaWEB.application.model.Employee;
import com.advancia.PiadineriaAdvanciaWEB.application.services.UserEJBService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserEJBServiceImpl implements UserEJBService {
    @EJB
    private UserService userService;
    @Inject
    private UserEJBMappers userEJBMappers;

    @Override
    public Employee getUser(String username, String password) {
        EmployeeEJB employeeEJB = userService.getUser(username, password);
        return userEJBMappers.convertFromEJB(employeeEJB);
    }

    @Override
    public List<Employee> getUsers() {
        List<EmployeeEJB> employeeEJBs = userService.getUsers();
        return userEJBMappers.convertFromEJB(employeeEJBs);
    }

    @Override
    public Employee getUserByID(int UID) {
        EmployeeEJB employeeEJB = userService.getUserByID(UID);
        return userEJBMappers.convertFromEJB(employeeEJB);
    }

    @Override
    public void createUser(Employee em) {
        EmployeeEJB employeeEJB = userEJBMappers.convertToEJB(em);
        userService.createUser(employeeEJB);
    }

    @Override
    public void updateUser(int UID, Employee emUpdated) {
        EmployeeEJB employeeEJB = userEJBMappers.convertToEJB(emUpdated);
        userService.updateUser(UID, employeeEJB);
    }

    @Override
    public void deleteUser(int UID) {
        userService.deleteUser(UID);
    }
}