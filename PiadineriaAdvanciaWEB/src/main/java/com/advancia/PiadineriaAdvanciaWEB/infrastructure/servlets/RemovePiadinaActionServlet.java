package com.advancia.PiadineriaAdvanciaWEB.infrastructure.servlets;

import com.advancia.PiadineriaAdvanciaWEB.domain.model.classes.Piadina;
import com.advancia.PiadineriaAdvanciaWEB.domain.services.PiadinaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet("/remove")
public class RemovePiadinaActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiadinaService piadinaService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			StringBuilder jsonBuffer = new StringBuilder();
			
	        try(BufferedReader reader = request.getReader()) {
	            String line;
	            while((line = reader.readLine()) != null) {
	                jsonBuffer.append(line);
	            }
	        }
	        ObjectMapper objectMapper = new ObjectMapper();
	        String piadinaName = objectMapper.readValue(jsonBuffer.toString(), String.class);
	        
			if(piadinaName != null && !piadinaName.isEmpty()) {
				List<Piadina> piadinas = piadinaService.getPiadinas();
				Piadina piadinaToRemove = null;
				
				for(Piadina p : piadinas) {
					if(p.getName().equalsIgnoreCase(piadinaName)) {
						piadinaToRemove = p;
						break;
					}
				}
				
				if(piadinaToRemove != null) {
					piadinaService.removePiadina(piadinaToRemove.getId());
					log.info("Piadina '{}' successfully removed.", piadinaName);
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					log.warn("Piadina '{}' not found.", piadinaName);
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} else {
				log.error("Piadina name parameter is missing or invalid.");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			return;
		}
		log.error("Load dashboard session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}