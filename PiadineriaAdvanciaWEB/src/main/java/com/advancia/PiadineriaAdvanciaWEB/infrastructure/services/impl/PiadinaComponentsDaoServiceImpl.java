package com.advancia.PiadineriaAdvanciaWEB.infrastructure.services.impl;

import com.advancia.PiadineriaAdvanciaEJB.ejb.dao.piadinacomponents.*;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.DoughEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.MeatBaseEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.OptionalElementsEJB;
import com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes.SaucesEJB;
import com.advancia.PiadineriaAdvanciaWEB.domain.exceptions.DBException;
import com.advancia.PiadineriaAdvanciaWEB.domain.repository.PiadinaComponentsDaoService;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Dough;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.MeatBase;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Sauces;
import com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers.ComponentsEJBMappers;
import com.advancia.PiadineriaAdvanciaWEB.infrastructure.mappers.UserEJBMappers;
import org.mapstruct.factory.Mappers;

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
	private final ComponentsEJBMappers componentsEJBMappers = Mappers.getMapper(ComponentsEJBMappers.class);
	private final PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	private final AddDoughDao addDoughDao = new AddDoughDao();
	private final AddMeatBaseDao addMeatBaseDao = new AddMeatBaseDao();
	private final AddSaucesDao addSaucesDao = new AddSaucesDao();
	private final AddOptionalElementsDao addOptionalElementsDao = new AddOptionalElementsDao();
	
	private final GetDoughDao getDoughDao = new GetDoughDao();
	private final GetMeatBaseDao getMeatBaseDao = new GetMeatBaseDao();
	private final GetSaucesDao getSaucesDao = new GetSaucesDao();
	private final GetOptionalElementsDao getOptionalElementsDao = new GetOptionalElementsDao();
	
	private final UpdateDoughDao updateDoughDao = new UpdateDoughDao();
	private final UpdateMeatBaseDao updateMeatBaseDao = new UpdateMeatBaseDao();
	private final UpdateSaucesDao updateSaucesDao = new UpdateSaucesDao();
	private final UpdateOptionalElementsDao updateOptionalElementsDao = new UpdateOptionalElementsDao();
	
	private final RemoveDoughDao removeDoughDao = new RemoveDoughDao();
	private final RemoveMeatBaseDao removeMeatBaseDao = new RemoveMeatBaseDao();
	private final RemoveSaucesDao removeSaucesDao = new RemoveSaucesDao();
	private final RemoveOptionalElementsDao removeOptionalElementsDao = new RemoveOptionalElementsDao();

	@Override
    public Map<String, Set<Object>> getAllComponents() {
        try {
            return piadinaComponentsDao.getAllComponents(em);
        } catch(Exception e) {
            throw new DBException("Error while retrieving piadina components.", e);
        }
    }

	@Override
    public void addDough(Dough d) {
    	try {
			DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
            addDoughDao.add(doughEJB, em);
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }

	@Override
    public void addMeatBase(MeatBase mt) {
    	try {
			MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
            addMeatBaseDao.add(meatBaseEJB, em);
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }

	@Override
    public void addSauces(Sauces s) {
    	try {
			SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
            addSaucesDao.add(saucesEJB, em);
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }

	@Override
	public void addOptionalElements(OptionalElements oe) {
		try {
			OptionalElementsEJB optionalElementsEJB = componentsEJBMappers.convertToEJB(oe);
	        addOptionalElementsDao.add(optionalElementsEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while adding optional elements.", e);
	    }
    }

	@Override
	public Dough getDough(int id) {
		try {
			DoughEJB doughEJB = getDoughDao.get(id, em);
			return componentsEJBMappers.convertFromEJB(doughEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving dough.", e);
	    }
    }

	@Override
    public MeatBase getMeatBase(int id) {
    	try {
			MeatBaseEJB meatBaseEJB = getMeatBaseDao.get(id, em);
			return componentsEJBMappers.convertFromEJB(meatBaseEJB);
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base.", e);
        }
    }

	@Override
    public Sauces getSauces(int id) {
    	try {
			SaucesEJB saucesEJB = getSaucesDao.get(id, em);
			return componentsEJBMappers.convertFromEJB(saucesEJB);
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces.", e);
        }
    }

	@Override
	public OptionalElements getOptionalElements(int id) {
		try {
			OptionalElementsEJB optionalElementsEJB = getOptionalElementsDao.get(id, em);
			return componentsEJBMappers.convertFromEJB(optionalElementsEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving optional elements.", e);
	    }
    }

	@Override
	public void updateDough(int id, Dough d) {
		try {
			DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
	        updateDoughDao.update(id, doughEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating dough.", e);
	    }
    }

	@Override
    public void updateMeatBase(int id, MeatBase mt) {
    	try {
			MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
            updateMeatBaseDao.update(id, meatBaseEJB, em);
        } catch(Exception e) {
            throw new DBException("Error while updating meat base.", e);
        }
    }

	@Override
    public void updateSauces(int id, Sauces s) {
    	try {
			SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
            updateSaucesDao.update(id, saucesEJB, em);
        } catch(Exception e) {
            throw new DBException("Error while updating sauces.", e);
        }
    }

	@Override
	public void updateOptionalElements(int id, OptionalElements oe) {
		try {
			OptionalElementsEJB optionalElementsEJB = componentsEJBMappers.convertToEJB(oe);
	        updateOptionalElementsDao.update(id, optionalElementsEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating optional elements.", e);
	    }
    }

	@Override
	public void deleteDough(int id) {
		try {
	        removeDoughDao.remove(id, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting dough.", e);
	    }
    }

	@Override
    public void deleteMeatBase(int id) {
    	try {
            removeMeatBaseDao.remove(id, em);
        } catch(Exception e) {
            throw new DBException("Error while deleting meat base.", e);
        }
    }

	@Override
    public void deleteSauces(int id) {
    	try {
            removeSaucesDao.remove(id, em);
        } catch(Exception e) {
            throw new DBException("Error while deleting sauces.", e);
        }
    }

	@Override
	public void deleteOptionalElements(int id) {
		try {
	        removeOptionalElementsDao.remove(id, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting optional elements.", e);
	    }
	}

	@Override
	public Dough getDoughByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			DoughEJB doughEJB = getDoughDao.getByType(type, em);
			return componentsEJBMappers.convertFromEJB(doughEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving dough by type.", e);
	    }
	}

	@Override
	public MeatBase getMeatBaseByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			MeatBaseEJB meatBaseEJB = getMeatBaseDao.getByType(type, em);
			return componentsEJBMappers.convertFromEJB(meatBaseEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving meat base by type.", e);
	    }
	}

	@Override
	public Sauces getSaucesByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			SaucesEJB saucesEJB = getSaucesDao.getByType(type, em);
			return componentsEJBMappers.convertFromEJB(saucesEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving sauces by type.", e);
	    }
	}

	@Override
	public OptionalElements getOptionalElementsByType(String type) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			OptionalElementsEJB optionalElementsEJB = getOptionalElementsDao.getByType(type, em);
			return componentsEJBMappers.convertFromEJB(optionalElementsEJB);
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving optional elements by type.", e);
	    }
	}

	@Override
	public void updateDoughByType(String type, Dough d) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			DoughEJB doughEJB = componentsEJBMappers.convertToEJB(d);
	        updateDoughDao.updateByType(type, doughEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating dough by type.", e);
	    }
	}

	@Override
	public void updateMeatBaseByType(String type, MeatBase mt) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			MeatBaseEJB meatBaseEJB = componentsEJBMappers.convertToEJB(mt);
	        updateMeatBaseDao.updateByType(type, meatBaseEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating meat base by type.", e);
	    }
	}

	@Override
	public void updateSaucesByType(String type, Sauces s) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			SaucesEJB saucesEJB = componentsEJBMappers.convertToEJB(s);
	        updateSaucesDao.updateByType(type, saucesEJB, em);
	    } catch(Exception e) {
	        throw new DBException("Error while updating sauces by type.", e);
	    }
	}

	@Override
	public void updateOptionalElementsByType(String type, OptionalElements oe) {
	    if(type == null || type.trim().isEmpty()) {
	        throw new IllegalArgumentException("Type must be a non-empty string");
	    }
	    try {
			OptionalElementsEJB optionalElementsEJB = componentsEJBMappers.convertToEJB(oe);
	        updateOptionalElementsDao.updateByType(type, optionalElementsEJB, em);
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
	        removeDoughDao.removeByType(type, em);
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
	        removeMeatBaseDao.removeByType(type, em);
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
	        removeSaucesDao.removeByType(type, em);
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
	        removeOptionalElementsDao.removeByType(type, em);
	    } catch(Exception e) {
	        throw new DBException("Error while deleting optional elements by type.", e);
	    }
	}
}