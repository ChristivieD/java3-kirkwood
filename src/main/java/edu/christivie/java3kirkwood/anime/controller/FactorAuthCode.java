package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.anime.models.User;
import edu.christivie.java3kirkwood.shared.ComServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/2fa-code")
public class FactorAuthCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resend = req.getParameter("resend");
        if(resend != null){
            HttpSession session = req.getSession();
            String codeFromSession = (String)session.getAttribute("code");
            if(codeFromSession != null && !codeFromSession.equals("")){
                String email = (String)session.getAttribute("email");
                ComServices.sendNewUserEmail(email,codeFromSession);
                req.setAttribute("emailSent","A new email was sent with your access code");
            }
        }

        req.setAttribute("pageTitle", "Confirm Your Code");
        req.getRequestDispatcher("WEB-INF/anime/2fa-code.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("inputCode");
        Map<String, String> results = new HashMap<>();
        results.put("code",code);

        HttpSession session = req.getSession();
        String codeFromSession = (String)session.getAttribute("code");
        if(!code.equals(codeFromSession)){
            results.put("codeError","That code is not correct");
        }else{
            String email = (String)session.getAttribute("email");
            User userFromDatabase = UsersDAO.get(email);
            userFromDatabase.setStatus("active");
            userFromDatabase.setPrivileges("user");
            UsersDAO.update(userFromDatabase);
            userFromDatabase.setPassword(null);
            session.removeAttribute("code");
            session.removeAttribute("email");
            session.setAttribute("activeUser", userFromDatabase);
            session.setAttribute("flashMessageSuccess","Welcome to View Anime!!!");
            resp.sendRedirect("anime");
            return;
        }

        req.setAttribute("results",results);
        req.setAttribute("pageTitle", "Confirm Your Code");
        req.getRequestDispatcher("WEB-INF/anime/2fa-code.jsp").forward(req, resp);
    }
}
