package com.advancia.PiadineriaAdvanciaEJB.infrastructure.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.model.SaucesEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaEJB.domain.repository.PiadinaComponentsDaoService;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.DoughEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.MeatBaseEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.OptionalElementsEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.SaucesEntity;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.dao.piadinacomponents.*;
import com.advancia.PiadineriaAdvanciaEJB.infrastructure.mappers.ComponentsEntityMappers;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;
import java.util.Set;

@Stateless
public class PiadinaComponentsDaoServiceImpl implements PiadinaComponentsDaoService {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private ComponentsEntityMappers componentsEntityMappers;
	private final PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	private final DoughDao doughDao = new DoughDao();
	private final MeatBaseDao meatBaseDao = new MeatBaseDao();
	private final SaucesDao saucesDao = new SaucesDao();
	private final OptionalElementsDao optionalElementsDao = new OptionalElementsDao();

	@Override
    public Map<String, Set<Object>> getAllComponents() {
        try {
            return piadinaComponentsDao.getAllComponents(em);
        } catch(Exception e) {
            throw new DBException("Error while retrieving piadina components.", e);
        }
    }

	@Override
    public void addDough(DoughEJB d) {
    	try {
			DoughEntity doughEntity = componentsEntityMappers.convertToEntity(d);
			doughDao.add(doughEntity, em);
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }

	@Override
    public void addMeatBase(MeatBaseEJB mt) {
    	try {
			MeatBaseEntity meatBaseEntity = componentsEntityMappers.convertToEntity(mt);
			meatBaseDao.add(meatBaseEntity, em);
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }

	@Override
    public void addSauces(SaucesEJB s) {
    	try {
			SaucesEntity saucesEntity = componentsEntityMappers.convertToEntity(s);
			saucesDao.add(saucesEntity, em);
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }

	@Override
	public void addOptionalElements(OptionalElementsEJB oe) {
		try {
			OptionalElementsEntity optionalElementsEntity = componentsEntityMappers.convertToEntity(oe);
			optionalElementsDao.add(optionalElementsEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while adding optional elements.", e);
	    }
    }

	@Override
	public DoughEJB getDough(int id) {
		try {
			DoughEntity doughEntity = doughDao.get(id, em);
			return componentsEntityMappers.convertFromEntity(doughEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving dough.", e);
	    }
    }

	@Override
    public MeatBaseEJB getMeatBase(int id) {
    	try {
			MeatBaseEntity meatBaseEntity = meatBaseDao.get(id, em);
			return componentsEntityMappers.convertFromEntity(meatBaseEntity);
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base.", e);
        }
    }

	@Override
    public SaucesEJB getSauces(int id) {
    	try {
			SaucesEntity saucesEntity = saucesDao.get(id, em);
			return componentsEntityMappers.convertFromEntity(saucesEntity);
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces.", e);
        }
    }

	@Override
	public OptionalElementsEJB getOptionalElements(int id) {
		try {
			OptionalElementsEntity optionalElementsEntity = optionalElementsDao.get(id, em);
			return componentsEntityMappers.convertFromEntity(optionalElementsEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving optional elements.", e);
	    }
    }

	@Override
	public void updateDough(int id, DoughEJB d) {
		try {
			DoughEntity doughEntity = componentsEntityMappers.convertToEntity(d);
			doughDao.update(id, doughEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating dough.", e);
	    }
    }

	@Override
    public void updateMeatBase(int id, MeatBaseEJB mt) {
    	try {
			MeatBaseEntity meatBaseEntity = componentsEntityMappers.convertToEntity(mt);
			meatBaseDao.update(id, meatBaseEntity, em);
        } catch(Exception e) {
            throw new DBException("Error while updating meat base.", e);
        }
    }

	@Override
    public void updateSauces(int id, SaucesEJB s) {
    	try {
			SaucesEntity saucesEntity = componentsEntityMappers.convertToEntity(s);
			saucesDao.update(id, saucesEntity, em);
        } catch(Exception e) {
            throw new DBException("Error while updating sauces.", e);
        }
    }

	@Override
	public void updateOptionalElements(int id, OptionalElementsEJB oe) {
		try {
			OptionalElementsEntity optionalElementsEntity = componentsEntityMappers.convertToEntity(oe);
			optionalElementsDao.update(id, optionalElementsEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating optional elements.", e);
	    }
    }

	@Override
	public void deleteDough(int id) {
		try {
			doughDao.remove(id, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting dough.", e);
	    }
    }

	@Override
    public void deleteMeatBase(int id) {
    	try {
			meatBaseDao.remove(id, em);
        } catch(Exception e) {
            throw new DBException("Error while deleting meat base.", e);
        }
    }

	@Override
    public void deleteSauces(int id) {
    	try {
			saucesDao.remove(id, em);
        } catch(Exception e) {
            throw new DBException("Error while deleting sauces.", e);
        }
    }

	@Override
	public void deleteOptionalElements(int id) {
		try {
			optionalElementsDao.remove(id, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting optional elements.", e);
	    }
	}

	@Override
	public DoughEJB getDoughByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			DoughEntity doughEntity = doughDao.getByType(type, em);
			return componentsEntityMappers.convertFromEntity(doughEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving dough by type.", e);
	    }
	}

	@Override
	public MeatBaseEJB getMeatBaseByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			MeatBaseEntity meatBaseEntity = meatBaseDao.getByType(type, em);
			return componentsEntityMappers.convertFromEntity(meatBaseEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving meat base by type.", e);
	    }
	}

	@Override
	public SaucesEJB getSaucesByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			SaucesEntity saucesEntity = saucesDao.getByType(type, em);
			return componentsEntityMappers.convertFromEntity(saucesEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving sauces by type.", e);
	    }
	}

	@Override
	public OptionalElementsEJB getOptionalElementsByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			OptionalElementsEntity optionalElementsEntity = optionalElementsDao.getByType(type, em);
			return componentsEntityMappers.convertFromEntity(optionalElementsEntity);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving optional elements by type.", e);
	    }
	}

	@Override
	public void updateDoughByType(String type, DoughEJB d) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			DoughEntity doughEntity = componentsEntityMappers.convertToEntity(d);
			doughDao.updateByType(type, doughEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating dough by type.", e);
	    }
	}

	@Override
	public void updateMeatBaseByType(String type, MeatBaseEJB mt) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			MeatBaseEntity meatBaseEntity = componentsEntityMappers.convertToEntity(mt);
			meatBaseDao.updateByType(type, meatBaseEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating meat base by type.", e);
	    }
	}

	@Override
	public void updateSaucesByType(String type, SaucesEJB s) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			SaucesEntity saucesEntity = componentsEntityMappers.convertToEntity(s);
			saucesDao.updateByType(type, saucesEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating sauces by type.", e);
	    }
	}

	@Override
	public void updateOptionalElementsByType(String type, OptionalElementsEJB oe) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			OptionalElementsEntity optionalElementsEntity = componentsEntityMappers.convertToEntity(oe);
			optionalElementsDao.updateByType(type, optionalElementsEntity, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating optional elements by type.", e);
	    }
	}

	@Override
	public void deleteDoughByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			doughDao.removeByType(type, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting dough by type.", e);
	    }
	}

	@Override
	public void deleteMeatBaseByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			meatBaseDao.removeByType(type, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting meat base by type.", e);
	    }
	}

	@Override
	public void deleteSaucesByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			saucesDao.removeByType(type, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting sauces by type.", e);
	    }
	}

	@Override
	public void deleteOptionalElementsByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			optionalElementsDao.removeByType(type, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting optional elements by type.", e);
	    }
	}
}