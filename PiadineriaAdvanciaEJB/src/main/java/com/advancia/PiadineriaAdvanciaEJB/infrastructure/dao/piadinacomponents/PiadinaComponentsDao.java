package com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents;

import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.DoughEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.MeatBaseEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.OptionalElementsEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.SaucesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Stateless
public class PiadinaComponentsDao {
	public Map<String, Set<Object>> getAllComponents(EntityManager em) {
        Map<String, Set<Object>> components = new HashMap<>();
        components.put("DOUGH", new HashSet<>());
        components.put("MEATBASE", new HashSet<>());
        components.put("SAUCES", new HashSet<>());
        components.put("OPTIONALELEMENTS", new HashSet<>());

        try {
            components.get("DOUGH").addAll(
                em.createQuery("SELECT d FROM DoughEntity d", DoughEntity.class).getResultList()
            );
            components.get("MEATBASE").addAll(
                em.createQuery("SELECT m FROM MeatBaseEntity m", MeatBaseEntity.class).getResultList()
            );
            components.get("SAUCES").addAll(
                em.createQuery("SELECT s FROM SaucesEntity s", SaucesEntity.class).getResultList()
            );
            components.get("OPTIONALELEMENTS").addAll(
                em.createQuery("SELECT o FROM OptionalElementsEntity o", OptionalElementsEntity.class).getResultList()
            );

            return components;
        } catch(Exception e) {
            throw new DBException("Error while getting piadina components from DB.", e);
        }
    }
}