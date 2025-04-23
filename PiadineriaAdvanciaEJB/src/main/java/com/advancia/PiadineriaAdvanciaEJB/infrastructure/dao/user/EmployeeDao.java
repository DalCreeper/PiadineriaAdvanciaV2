package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.user;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.EmployeeEntity;

import java.util.List;

@Stateless
public class EmployeeDao {
    private static final String GET_USER_BY_USERNAME_PASSWORD = "SELECT e FROM EmployeeEntity e WHERE e.username = :username AND e.password = :password";
    private static final String GET_ALL_EMPLOYEES = "SELECT e FROM EmployeeEntity e";

    public EmployeeEntity getEmployee(EntityManager em, String username, String password) {
        try {
            TypedQuery<EmployeeEntity> query = em.createQuery(GET_USER_BY_USERNAME_PASSWORD, EmployeeEntity.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch(NoResultException e) {
            throw new DBException("No user found for username: " + username, e);
        } catch(Exception e) {
            throw new DBException("Error while getting user with username: " + username, e);
        }
    }

    public EmployeeEntity getEmployeeByID(EntityManager em, int UID) {
        try {
            return em.find(EmployeeEntity.class, UID);
        } catch(NoResultException e) {
            throw new DBException("No user found for id: " + UID, e);
        } catch(Exception e) {
            throw new DBException("Error while getting employee by UID: " + UID, e);
        }
    }

    public void create(EntityManager em, EmployeeEntity employeeEntity) {
        try {
            em.persist(employeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while creating a new employee", e);
        }
    }

    public void update(EntityManager em, int UID, EmployeeEntity emUpdated) {
        try {
            EmployeeEntity existingEmployeeEntity = em.find(EmployeeEntity.class, UID);
            if(existingEmployeeEntity == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            existingEmployeeEntity.setName(emUpdated.getName());
            existingEmployeeEntity.setSurname(emUpdated.getSurname());
            existingEmployeeEntity.setUsername(emUpdated.getUsername());
            existingEmployeeEntity.setYob(emUpdated.getYob());
            existingEmployeeEntity.setRole(emUpdated.getRole());

            em.merge(existingEmployeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while updating employee with UID: " + UID, e);
        }
    }

    public void delete(EntityManager em, int UID) {
        try {
            EmployeeEntity employeeEntity = em.find(EmployeeEntity.class, UID);
            if(employeeEntity == null) {
                throw new DBException("Employee with UID: " + UID + " not found");
            }

            em.remove(employeeEntity);
        } catch(Exception e) {
            throw new DBException("Error while deleting employee with UID: " + UID, e);
        }
    }

    public List<EmployeeEntity> getEmployees(EntityManager em) {
        try {
            TypedQuery<EmployeeEntity> query = em.createQuery(GET_ALL_EMPLOYEES, EmployeeEntity.class);
            return query.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting the list of employees", e);
        }
    }
}