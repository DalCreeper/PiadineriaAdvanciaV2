package com.advancia.PiadineriaAdvanciaEJB.infrastructure.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.EmployeeEJB;
import com.advancia.PiadineriaAdvanciaEJB.domain.services.UserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String rememberMe = request.getParameter("rememberMe");
        Optional<EmployeeEJB> employee = getEmployeeOrFail(request, response);

        if(employee.isPresent()) {
            httpSession.setAttribute("user", employee.get());
            httpSession.setAttribute("rememberMe", rememberMe);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
    }

    private Optional<EmployeeEJB> getEmployeeOrFail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            EmployeeEJB employee = userService.getUser(username, password);
            log.info("Login successful for user = {}", username);
            return Optional.of(employee);
        } catch(Exception e) {
            log.warn("Login failed for user = {}", username);
            httpSession.setAttribute("errorMessage", "Invalid username or password!");
            response.sendRedirect(request.getContextPath() + "/loadLogin");
            return Optional.empty();
        }
    }
}