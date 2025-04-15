package com.advancia.PiadineriaAdvanciaEJB.infrastructure.servlets;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			httpSession.invalidate();
			log.info("Logout successful.");
			response.sendRedirect(request.getContextPath() + "/loadLogin");
	        return;
		}
		log.error("Logout failed.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}