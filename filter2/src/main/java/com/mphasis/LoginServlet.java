package com.mphasis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display login form
        request.getRequestDispatcher("/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded username and password validation (this should be replaced with a proper user validation mechanism)
        if ("admin".equals(username) && "password123".equals(password)) {
            // Valid login, create a session for the user
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to OTP page after successful login
            response.sendRedirect(request.getContextPath() + "/otp.html");  // Redirect to OTP page
        } else {
            // Invalid login, redirect back to login page with error
            response.sendRedirect(request.getContextPath() + "/login.html?error=true");  // Redirect to login page with error
        }
    }
}
