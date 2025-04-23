package com.advancia.PiadineriaAdvanciaWEB.application.servlets;

import com.advancia.PiadineriaAdvanciaWEB.application.services.PiadinaEJBService;
import lombok.extern.log4j.Log4j2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Log4j2
@WebServlet("/addPiadina")
public class LoadAddPiadinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiadinaEJBService piadinaEJBService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Map<String, Set<Object>> components = piadinaEJBService.getPiadinaComponents();
			request.setAttribute("doughs", components.get("DOUGH"));
			request.setAttribute("mBases", components.get("MEATBASE"));
			request.setAttribute("sauces", components.get("SAUCES"));
			request.setAttribute("oElements", components.get("OPTIONALELEMENTS"));
			log.info("Load AddPiadina successful.");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
			return;
		}
		log.error("Load AddPiadina session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}