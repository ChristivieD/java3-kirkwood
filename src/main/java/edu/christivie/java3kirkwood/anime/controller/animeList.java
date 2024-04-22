package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.AnimeDAO;
import edu.christivie.java3kirkwood.anime.models.Anime;
import edu.christivie.java3kirkwood.anime.models.AnimeGenre;
import edu.christivie.java3kirkwood.anime.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.TreeMap;

@WebServlet("/animeList")
public class animeList extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] genreParams = req.getParameterValues("genre");
        String statusFilter = req.getParameter("genre-status");
        String genreFilter = "";
        if (genreParams != null && genreParams.length > 0) {
            genreFilter = String.join(",", genreParams);
        }
        if (genreFilter == null || genreFilter.isEmpty()) {
            statusFilter = "";
        }
        int limit = 5;
        int offset = 0;
        List<Anime> animes = AnimeDAO.get(limit, offset, genreFilter, statusFilter);
        List<AnimeGenre> genres = AnimeDAO.getAllGenres();
        HttpSession session = req.getSession();
        User userFromSession = (User) session.getAttribute("activeUser");
        if (userFromSession != null) {
            TreeMap<Anime, Instant> animeGenre = AnimeDAO.getAnimeGenre(limit, offset, userFromSession.getUser_id());
            req.setAttribute("animeGenre", animeGenre);
        }
        req.setAttribute("animes", animes);
        req.setAttribute("genres", genres);
        req.setAttribute("pageTitle","Home");
        req.getRequestDispatcher("WEB-INF/anime/animeList.jsp").forward(req,resp);
    }
}
