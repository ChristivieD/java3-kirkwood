package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.AnimeDAO;
import edu.christivie.java3kirkwood.anime.models.Anime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;
import java.util.TreeMap;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        TreeMap<Anime, Instant> animeSearch = AnimeDAO.getAnimeGenre(10,0,"","");
        req.setAttribute("animeSearch", animeSearch);
        req.getRequestDispatcher("WEB-INF/anime/search.jsp").forward(req,resp);
    }
}
