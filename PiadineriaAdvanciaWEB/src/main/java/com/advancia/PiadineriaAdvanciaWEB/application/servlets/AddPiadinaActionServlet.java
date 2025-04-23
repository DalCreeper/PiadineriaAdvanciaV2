package com.advancia.PiadineriaAdvanciaWEB.application.servlets;

import com.advancia.PiadineriaAdvanciaWEB.application.model.*;
import com.advancia.PiadineriaAdvanciaWEB.application.services.PiadinaEJBService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Log4j2
@WebServlet("/add")
public class AddPiadinaActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiadinaEJBService piadinaEJBService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			ObjectMapper mapper = new ObjectMapper();
			PiadinaDeserialize piadinaDeserialized = mapper.readValue(request.getInputStream(), PiadinaDeserialize.class);
			Map<String, Set<Object>> components = piadinaEJBService.getPiadinaComponents();

			Set<Dough> doughs = castToSet(components.get("DOUGH"), Dough.class);
			Set<MeatBase> meatBase = castToSet(components.get("MEATBASE"), MeatBase.class);
			Set<Sauces> sauces = castToSet(components.get("SAUCES"), Sauces.class);
			Set<OptionalElements> optionalElements = castToSet(components.get("OPTIONALELEMENTS"), OptionalElements.class);

			Dough chosenDough = null;
			Set<MeatBase> chosenMeatBases = new HashSet<>();
			Set<Sauces> chosenSauces = new HashSet<>();
			Set<OptionalElements> chosenOptionalElements = new HashSet<>();
	        
	        for(Dough d : doughs) {
	        	if(piadinaDeserialized.getDough() == d.getId()) {
	        		chosenDough = d;
	        		break;
	        	}
	        }
	        for(int meatType : piadinaDeserialized.getMeatBase()) {
	            for(MeatBase m : meatBase) {
	                if(meatType == m.getId()) {
	                    chosenMeatBases.add(m);
	                }
	            }
	        }
	        for(int sauceType : piadinaDeserialized.getSauces()) {
	            for(Sauces s : sauces) {
	                if(sauceType == s.getId()) {
	                    chosenSauces.add(s);
	                }
	            }
	        }
	        for(int optionalType : piadinaDeserialized.getOptionalElements()) {
	            for(OptionalElements o : optionalElements) {
	                if(optionalType == o.getId()) {
	                    chosenOptionalElements.add(o);
	                }
	            }
	        }
	        
	        Piadina p = new Piadina(
	            piadinaDeserialized.getName(),
	            chosenDough,
	            chosenMeatBases,
	            chosenSauces,
	            chosenOptionalElements,
	            piadinaDeserialized.getPrice(),
	            (Employee) httpSession.getAttribute("user")
	        );
			piadinaEJBService.addPiadina(p);
	        
	        log.info("Piadina {}\n\tSuccessfully added.", p.toString());
	        response.setStatus(HttpServletResponse.SC_OK);
	        return;
		}
		log.error("Load dashboard session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
	
	private static <T> Set<T> castToSet(Object attribute, Class<T> clazz) {
        if(attribute instanceof Set<?>) {
        	Set<?> tempList = (Set<?>) attribute;
        	Set<T> resultList = new HashSet<>();
            for(Object item : tempList) {
                if(clazz.isInstance(item)) {
                    resultList.add(clazz.cast(item));
                } else {
                    throw new IllegalArgumentException("Invalid type in list for " + clazz.getSimpleName());
                }
            }
            return resultList;
        } else {
            throw new IllegalArgumentException("Attribute is not a list");
        }
    }
}