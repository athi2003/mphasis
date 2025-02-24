package com.mphasis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jaa")
public class Demo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Demo() {
        super();
    }

    // Handle GET request to serve the HTML form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // HTML and CSS for a nice form
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Servlet Form</title>");
        pw.println("<style>");
        pw.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        pw.println("h1 { text-align: center; color: #333; }");
        pw.println(".form-container { width: 50%; margin: 50px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }");
        pw.println(".form-container input[type='text'], .form-container input[type='submit'] { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }");
        pw.println(".form-container input[type='submit'] { background-color: #4CAF50; color: white; cursor: pointer; }");
        pw.println(".form-container input[type='submit']:hover { background-color: #45a049; }");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        // Form
        pw.println("<div class='form-container'>");
        pw.println("<h1>Servlet Form Submission</h1>");
        pw.println("<form method='POST' action='jaa'>");
        pw.println("<label for='name'>Name:</label>");
        pw.println("<input type='text' id='name' name='name' required>");
        pw.println("<label for='email'>Email:</label>");
        pw.println("<input type='text' id='email' name='email' required>");
        pw.println("<input type='submit' value='Submit'>");
        pw.println("</form>");
        pw.println("</div>");

        pw.println("</body>");
        pw.println("</html>");
    }

    // Handle POST request to process form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // HTML to display the submitted form data
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Form Submission Result</title>");
        pw.println("<style>");
        pw.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        pw.println("h1 { text-align: center; color: #333; }");
        pw.println(".result-container { width: 50%; margin: 50px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); text-align: center; }");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("<div class='result-container'>");
        pw.println("<h1>Form Submission Successful!</h1>");
        pw.println("<p><strong>Name:</strong> " + name + "</p>");
        pw.println("<p><strong>Email:</strong> " + email + "</p>");
        pw.println("</div>");

        pw.println("</body>");
        pw.println("</html>");
    }
}
