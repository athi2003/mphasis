package com.mphasis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/otp")
public class OtpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display OTP form
        request.getRequestDispatcher("/otp.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp");

        // For simplicity, we'll retrieve the generated OTP from the session
        HttpSession session = request.getSession();
        String generatedOtp = "123";

        // Check if the entered OTP matches the generated OTP
        if (generatedOtp != null && generatedOtp.equals(enteredOtp)) {
            // OTP is correct, mark it as verified
            session.setAttribute("otpVerified", true);

            // Redirect to the protected welcome page after OTP verification
            response.sendRedirect(request.getContextPath() + "/welcome.html");  // Redirect to protected page
        } else {
            // OTP is incorrect, redirect back to OTP page with error
            response.sendRedirect(request.getContextPath() + "/otp.html?error=true");  // Redirect to OTP page with error
        }
    }
}
