package com.advancia.PiadineriaAdvanciaWEB.infrastructure.servlets;

import com.advancia.PiadineriaAdvanciaEJB.ejb.services.LoginServiceBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loadLogin")
public class LoadLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = LogManager.getLogger(LoadLoginServlet.class);
    @EJB
    private LoginServiceBean loginService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);

        if(httpSession != null) {
            Object rememberMe = httpSession.getAttribute("rememberMe");

            if(loginService.isRemembered(rememberMe)) {
                log.info("Load login successful.");
                response.sendRedirect(request.getContextPath() + "/dashboard");
                return;
            }
        }
        log.warn("Load login session not found.");
        request.getRequestDispatcher("loginForm.jsp").forward(request, response);
    }
}