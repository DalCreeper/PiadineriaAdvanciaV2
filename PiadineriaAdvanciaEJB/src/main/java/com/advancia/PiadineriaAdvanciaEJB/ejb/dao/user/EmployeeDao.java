package com.advancia.PiadineriaAdvanciaEJB.ejb.dao.user;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.advancia.PiadineriaAdvanciaEJB.ejb.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.EmployeeEJB;

@Stateless
public class EmployeeDao {
    private static final String GET_USER_BY_USERNAME_PASSWORD = "SELECT e FROM EmployeeEJB e WHERE e.username = :username AND e.password = :password";

    public EmployeeEJB getEmployee(EntityManager em, String username, String password) {
        try {
            TypedQuery<EmployeeEJB> query = em.createQuery(GET_USER_BY_USERNAME_PASSWORD, EmployeeEJB.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch(NoResultException e) {
            throw new DBException("No user found for username: " + username, e);
        } catch(Exception e) {
            throw new DBException("Error while getting user with username: " + username, e);
        }
    }
}