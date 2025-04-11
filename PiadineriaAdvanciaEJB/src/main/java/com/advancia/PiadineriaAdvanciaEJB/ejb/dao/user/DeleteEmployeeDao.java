package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class DeleteEmployeeDao {
    public void delete(EntityManager em, int UID) {
        try {
            EmployeeEJB employeeEJB = em.find(EmployeeEJB.class, UID);
            if(employeeEJB == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            em.remove(employeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
    }
}