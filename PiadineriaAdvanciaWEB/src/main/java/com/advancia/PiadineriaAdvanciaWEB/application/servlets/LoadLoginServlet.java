package com.advancia.PiadineriaAdvanciaWEB.application.servlets;

import com.advancia.PiadineriaAdvanciaEJB.infrastructure.services.impl.LoginServiceBean;
import lombok.extern.log4j.Log4j2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet("/loadLogin")
public class LoadLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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