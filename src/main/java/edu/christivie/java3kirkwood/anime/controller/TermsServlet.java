package edu.christivie.java3kirkwood.anime.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/termsAndCondition")
public class TermsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle","terms-and-condition");
        req.getRequestDispatcher("WEB-INF/anime/termsAndCondition.jsp").forward(req,resp);
    }
}
