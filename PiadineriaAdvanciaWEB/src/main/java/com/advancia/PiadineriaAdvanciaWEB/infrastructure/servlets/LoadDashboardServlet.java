package com.advancia.PiadineriaAdvanciaWEB.infrastructure.servlets;

import com.advancia.PiadineriaAdvanciaWEB.domain.services.PiadinaService;
import lombok.extern.log4j.Log4j2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet("/dashboard")
public class LoadDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PiadinaService piadinaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Object user = httpSession.getAttribute("user");
			
			if(user != null) {
				request.setAttribute("piadinas", piadinaService.getPiadinas());
				log.info("Load dashboard successful.");
		        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		        return;
		    }
			httpSession.invalidate();
		}
		log.error("Load dashboard session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}