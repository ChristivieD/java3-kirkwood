package edu.christivie.java3kirkwood.demos;

import edu.christivie.java3kirkwood.shared.CommunicationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("WEB-INF/demos/email.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Get the parameters from the request object
        // create a communicationService object, and call a method to send an email
        // set a "success" attribute
        // forward the request to the java servlet page
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");

        boolean messageSent = CommunicationService.sendEmail(email,subject,message);
        req.setAttribute("success",messageSent);
        req.getRequestDispatcher("WEB-INF/demos/email.jsp").forward(req,resp);
    }

}
