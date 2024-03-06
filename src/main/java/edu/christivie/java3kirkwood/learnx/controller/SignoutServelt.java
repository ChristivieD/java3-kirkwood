package edu.christivie.java3kirkwood.learnx.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/signout")
public class SignoutServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Get existing session
//        session.invalidate(); // Remove all existing session attributes
        session.removeAttribute("activeUser");
//        session = req.getSession(); // Create new session
        session.setAttribute("flashMessageWarning", "You are logged out. See you next time!");
        resp.sendRedirect("learnx");
    }
}
