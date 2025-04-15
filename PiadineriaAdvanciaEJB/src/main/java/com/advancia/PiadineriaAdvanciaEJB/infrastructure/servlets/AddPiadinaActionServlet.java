package com.advancia.PiadineriaAdvanciaEJB.infrastructure.servlets;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.*;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaComponentsService;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.PiadinaService;
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
	private PiadinaComponentsService piadinaComponentsService;
	@EJB
	private PiadinaService piadinaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			ObjectMapper mapper = new ObjectMapper();
			PiadinaDeserializeEJB piadinaDeserialized = mapper.readValue(request.getInputStream(), PiadinaDeserializeEJB.class);
			Map<String, Set<Object>> components = piadinaComponentsService.getPiadinaComponents();

			Set<DoughEJB> doughs = castToSet(components.get("DOUGH"), DoughEJB.class);
			Set<MeatBaseEJB> meatBase = castToSet(components.get("MEATBASE"), MeatBaseEJB.class);
			Set<SaucesEJB> sauces = castToSet(components.get("SAUCES"), SaucesEJB.class);
			Set<OptionalElementsEJB> optionalElements = castToSet(components.get("OPTIONALELEMENTS"), OptionalElementsEJB.class);

			DoughEJB chosenDough = null;
			Set<MeatBaseEJB> chosenMeatBases = new HashSet<>();
			Set<SaucesEJB> chosenSauces = new HashSet<>();
			Set<OptionalElementsEJB> chosenOptionalElements = new HashSet<>();
	        
	        for(DoughEJB d : doughs) {
	        	if(piadinaDeserialized.getDough() == d.getId()) {
	        		chosenDough = d;
	        		break;
	        	}
	        }
	        for(int meatType : piadinaDeserialized.getMeatBase()) {
	            for(MeatBaseEJB m : meatBase) {
	                if(meatType == m.getId()) {
	                    chosenMeatBases.add(m);
	                }
	            }
	        }
	        for(int sauceType : piadinaDeserialized.getSauces()) {
	            for(SaucesEJB s : sauces) {
	                if(sauceType == s.getId()) {
	                    chosenSauces.add(s);
	                }
	            }
	        }
	        for(int optionalType : piadinaDeserialized.getOptionalElements()) {
	            for(OptionalElementsEJB o : optionalElements) {
	                if(optionalType == o.getId()) {
	                    chosenOptionalElements.add(o);
	                }
	            }
	        }
	        
	        PiadinaEJB p = new PiadinaEJB(
	            piadinaDeserialized.getName(),
	            chosenDough,
	            chosenMeatBases,
	            chosenSauces,
	            chosenOptionalElements,
	            piadinaDeserialized.getPrice(),
	            (EmployeeEJB) httpSession.getAttribute("user")
	        );
	        piadinaService.addPiadina(p);
	        
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