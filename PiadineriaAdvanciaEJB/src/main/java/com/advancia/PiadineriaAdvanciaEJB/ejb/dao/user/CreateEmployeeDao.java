package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class CreateEmployeeDao {
    public void create(EntityManager em, EmployeeEJB employeeEJB) {
        try {
            em.persist(employeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while creating a new employee", e);
        }
    }
}