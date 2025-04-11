package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EmployeesDao {
    private static final String GET_ALL_EMPLOYEES = "SELECT e FROM EmployeeEJB e";

    public List<EmployeeEJB> getEmployees(EntityManager em) {
        try {
            TypedQuery<EmployeeEJB> query = em.createQuery(GET_ALL_EMPLOYEES, EmployeeEJB.class);
            return query.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting the list of employees", e);
        }
    }
}
