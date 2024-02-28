package edu.christivie.java3kirkwood.learnx.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/terms-and-condition")
public class TermsAndCondition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle","terms-and-condition");
        req.getRequestDispatcher("WEB-INF/learnx/terms-and-condition.jsp").forward(req,resp);
    }
}
