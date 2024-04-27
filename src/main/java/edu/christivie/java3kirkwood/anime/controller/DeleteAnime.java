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


@WebServlet("/deleteAnime")
public class DeleteAnime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("activeUser");
        if (user == null) {
            session.setAttribute("flashMessageWarning", "You must log in to view this content");
            resp.sendRedirect("access?redirect=access");
            return;
        }
        req.getRequestDispatcher("WEB-INF/anime/deleteAnime.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String animeId = req.getParameter("anime_id");
        int id = Integer.parseInt(animeId);
        Anime anime = AnimeDAO.getAnimeById(id);
        HttpSession session = req.getSession();
        User adminUser = (User) session.getAttribute("activeUser");

        if (adminUser == null || !adminUser.getPrivileges().equals("admin")) {
            resp.sendRedirect("access?redirect=access");
            return;
        }
        if (anime != null && !anime.equals(animeId)) {
            if (anime != null) {
                // Delete the anime
                AnimeDAO.delete(anime);
                session.setAttribute("flashMessage", "User deleted successfully");
            }
        } else {
            session.setAttribute("flashMessage", "You cannot delete this user");
        }
        resp.sendRedirect("access?redirect=animeList");
    }
}
