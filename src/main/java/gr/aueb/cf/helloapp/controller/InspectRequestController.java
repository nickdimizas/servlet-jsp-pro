package gr.aueb.cf.helloapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/inspect-request")
public class InspectRequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(false);    // false: get current session (if exists) else return null

        if (username != null && username.equals("thanassis") && password != null && password.equals("12345")) {
            session.setAttribute("username", username);
            session.setAttribute("role", "TEACHER");

        }

        response.sendRedirect("/school-app/teachers");
        return;




//        response.getWriter().write("Session id: " + request.getSession() + "\n");
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("JSESSIONID")) {
//                    response.getWriter().write("Cookie name: " + cookie.getName() + ", Cookie Value: " + cookie.getValue() + "\n");
//                }
//            }
//        }
//
//        response.getWriter().write("Request URI: " + request.getRequestURI() + "\n");
//        response.getWriter().write("Request Context Path: " + request.getContextPath() + "\n");
//        response.getWriter().write("Request Servlet Path: " + request.getServletPath() + "\n");
    }
}