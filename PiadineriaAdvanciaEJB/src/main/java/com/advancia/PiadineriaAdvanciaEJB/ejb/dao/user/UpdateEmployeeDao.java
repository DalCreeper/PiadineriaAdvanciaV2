package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class UpdateEmployeeDao {
    public void update(EntityManager em, int UID, EmployeeEJB emUpdated) {
        try {
            EmployeeEJB existingEmployeeEJB = em.find(EmployeeEJB.class, UID);
            if(existingEmployeeEJB == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            existingEmployeeEJB.setName(emUpdated.getName());
            existingEmployeeEJB.setSurname(emUpdated.getSurname());
            existingEmployeeEJB.setUsername(emUpdated.getUsername());
            existingEmployeeEJB.setYob(emUpdated.getYob());
            existingEmployeeEJB.setRole(emUpdated.getRole());

            em.merge(existingEmployeeEJB);
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
    }
}