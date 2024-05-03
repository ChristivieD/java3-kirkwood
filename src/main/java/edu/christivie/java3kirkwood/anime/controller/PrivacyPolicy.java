package edu.christivie.java3kirkwood.anime.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet("/privacyPolicy")
public class PrivacyPolicy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle","Privacy Policy");
        req.getRequestDispatcher("WEB-INF/anime/privacyPolicy.jsp").forward(req,resp);
    }
}
