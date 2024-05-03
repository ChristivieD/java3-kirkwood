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


@WebServlet("/deleteAnime")
public class DeleteAnime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = req.getParameter("redirect");
        req.setAttribute("redirect", redirect);
        req.setAttribute("pageTitle", "Delete an anime");
        List<Anime> allAnime = AnimeDAO.getAnimes(20,0,"","");
        req.setAttribute("animes", allAnime);

        req.getRequestDispatcher("WEB-INF/anime/deleteAnime.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int animeId = Integer.parseInt(req.getParameter("inputAnimeID"));
        Anime anime = new Anime();
        anime.setAnime_id(animeId);
        HttpSession session = req.getSession();
        User adminUser = (User) session.getAttribute("activeUser");

        if (adminUser == null || !adminUser.getPrivileges().equals("admin")) {
            resp.sendRedirect("access?redirect=access");
            return;
        }
        if (anime != null) {
            // Delete the anime
            AnimeDAO.delete(anime);
            session.setAttribute("flashMessageSuccess", "Anime deleted successfully");
        }
        else {
            session.setAttribute("flashMessageWarning", "the deletion failed");
        }
        List<Anime> allAnime = AnimeDAO.getAnimes(20,0,"","");
        req.setAttribute("animes", allAnime);
        req.setAttribute("pageTitle", "Delete an anime");
        resp.sendRedirect("animeList");
    }
}
