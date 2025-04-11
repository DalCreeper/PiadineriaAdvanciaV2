package com.advancia.PiadineriaAdvanciaWEB.infrastructure.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;

import com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user.*;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.enums.RoleEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Employee;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.enums.Role;
import com.advancia.PiadineriaAdvanciaWEB.domain.repository.EmployeeDaoService;
import com.advancia.PiadineriaAdvanciaWEB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers.UserEJBMappers;
import org.mapstruct.factory.Mappers;

@Stateless
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
    @PersistenceContext
    private EntityManager em;
    private final UserEJBMappers userEJBMappers = Mappers.getMapper(UserEJBMappers.class);
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final EmployeesDao employeesDao = new EmployeesDao();
    private final EmployeeByIDDao employeeByIDDao = new EmployeeByIDDao();
    private final CreateEmployeeDao createEmployeeDao = new CreateEmployeeDao();
    private final UpdateEmployeeDao updateEmployeeDao = new UpdateEmployeeDao();
    private final DeleteEmployeeDao deleteEmployeeDao = new DeleteEmployeeDao();

    @Override
    public Employee getEmployee(String username, String password) {
        try {
            EmployeeEJB employeeEJB = employeeDao.getEmployee(em, username, password);
            return userEJBMappers.convertFromEJB(employeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with username: " + username, e);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try {
            List<EmployeeEJB> employeesEJB = employeesDao.getEmployees(em);
            return userEJBMappers.convertFromEJB(employeesEJB);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employees list", e);
        }
    }

    @Override
    public Employee getEmployee(int UID) {
        try {
            EmployeeEJB employeeEJB = employeeByIDDao.getEmployeeByID(em, UID);
            return userEJBMappers.convertFromEJB(employeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with UID: " + UID, e);
        }
    }

    @Override
    public void createEmployee(Employee employee) {
        try {
            EmployeeEJB employeeEJB = userEJBMappers.convertToEJB(employee);
            createEmployeeDao.create(em, employeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while creating employee", e);
        }
    }

    @Override
    public void updateEmployee(int UID, Employee emUpdated) {
        try {
            EmployeeEJB emUpdatedEJB = userEJBMappers.convertToEJB(emUpdated);
            updateEmployeeDao.update(em, UID, emUpdatedEJB);
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
    }

    @Override
    public void deleteEmployee(int UID) {
        try {
            deleteEmployeeDao.delete(em, UID);
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
    }
}