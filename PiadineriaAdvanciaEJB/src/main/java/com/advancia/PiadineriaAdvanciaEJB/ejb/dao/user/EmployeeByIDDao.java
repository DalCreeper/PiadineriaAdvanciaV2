package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Stateless
public class EmployeeByIDDao {
    public EmployeeEJB getEmployeeByID(EntityManager em, int UID) {
        try {
            return em.find(EmployeeEJB.class, UID);
        } catch(NoResultException e) {
            throw new DBException("No user found for id: " + UID, e);
        } catch(Exception e) {
            throw new DBException("Error while getting employee by UID: " + UID, e);
        }
    }
}