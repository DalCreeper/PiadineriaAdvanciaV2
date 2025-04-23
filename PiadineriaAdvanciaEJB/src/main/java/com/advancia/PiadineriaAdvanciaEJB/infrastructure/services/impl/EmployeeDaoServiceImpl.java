package com.advancia.PiadineriaAdvanciaEJB.infrastructure.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.repository.EmployeeDaoService;
import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.user.EmployeeDao;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers.UserEntityMappers;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.EmployeeEntity;

@Stateless
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private UserEntityMappers userEntityMappers;
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public EmployeeEJB getEmployee(String username, String password) {
        try {
            EmployeeEntity employeeEntity = employeeDao.getEmployee(em, username, password);
            return userEntityMappers.convertFromEntity(employeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with username: " + username, e);
        }
    }

    @Override
    public List<EmployeeEJB> getEmployees() {
        try {
            List<EmployeeEntity> employeesEntity = employeeDao.getEmployees(em);
            return userEntityMappers.convertFromEntity(employeesEntity);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employees list", e);
        }
    }

    @Override
    public EmployeeEJB getEmployee(int UID) {
        try {
            EmployeeEntity employeeEntity = employeeDao.getEmployeeByID(em, UID);
            return userEntityMappers.convertFromEntity(employeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while retrieving employee with UID: " + UID, e);
        }
    }

    @Override
    public void createEmployee(EmployeeEJB employee) {
        try {
            EmployeeEntity employeeEntity = userEntityMappers.convertToEntity(employee);
            employeeDao.create(em, employeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while creating employee", e);
        }
    }

    @Override
    public void updateEmployee(int UID, EmployeeEJB emUpdated) {
        try {
            EmployeeEntity emUpdatedEntity = userEntityMappers.convertToEntity(emUpdated);
            employeeDao.update(em, UID, emUpdatedEntity);
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
    }

    @Override
    public void deleteEmployee(int UID) {
        try {
            employeeDao.delete(em, UID);
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
    }
}