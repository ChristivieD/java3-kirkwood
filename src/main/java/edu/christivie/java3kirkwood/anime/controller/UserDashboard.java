package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.AnimeDAO;
import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.anime.models.Anime;
import edu.christivie.java3kirkwood.anime.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");
        if(userFromSession == null || !userFromSession.getPrivileges().equals("user")) {
            session.setAttribute("flashMessageWarning", "You must be logged in as a premium user to view this content");
            resp.sendRedirect("access?redirect=user");
            return;
        }
        User user = UsersDAO.getUserById(userFromSession.getUser_id());
        req.setAttribute("user", user);
        req.setAttribute("pageTitle", "User Dashboard");
        req.getRequestDispatcher("WEB-INF/anime/userboard.jsp").forward(req, resp);
    }
}
