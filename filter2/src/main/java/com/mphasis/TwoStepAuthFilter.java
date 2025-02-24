package com.mphasis;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/protected/*")  // Filter applied to all URLs under '/protected/'
public class TwoStepAuthFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization (if needed)
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        // Step 1: Check if the user is authenticated
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");  // Redirect to login page if not authenticated
            return;
        }

        // Step 2: Check if OTP is verified
        if (session.getAttribute("otpVerified") == null || !(boolean) session.getAttribute("otpVerified")) {
            resp.sendRedirect(req.getContextPath() + "/otp");  // Redirect to OTP verification page if OTP not verified
            return;
        }

        // If both conditions are met, proceed with the request
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Cleanup (if needed)
    }
}
