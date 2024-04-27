package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.AnimeDAO;
import edu.christivie.java3kirkwood.anime.models.Anime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/animeAdding")
public class AnimeAdding extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = req.getParameter("redirect");
        req.setAttribute("redirect", redirect);
        req.setAttribute("pageTitle", "Add anime");
        req.getRequestDispatcher("WEB-INF/anime/animeAdding.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("inputDate");
        int genreId = Integer.parseInt(req.getParameter("inputGenre"));
        String description = req.getParameter("inputDescription");
        String rating = req.getParameter("inputRating");
        String image = req.getParameter("inputImage");
        String status = req.getParameter("inputStatus");
        String language = req.getParameter("inputLanguage");
        String title = req.getParameter("inputTitle");
        Map<String, String> results = new HashMap<>();
        results.put("date", date);
        results.put("genreId", String.valueOf(genreId));
        results.put("description", description);
        results.put("rating", rating);
        results.put("image", image);
        results.put("status", status);
        results.put("language", language);
        results.put("title", title);
        Anime anime = AnimeDAO.addAnime(date, genreId, description,rating,image,status,language,title);
        if (anime != null) {
            HttpSession session = req.getSession();
            session.setAttribute("flashMessageSuccess","Anime '" + title + "' has been successfully added.");

            resp.sendRedirect(req.getContextPath() + "/animeList");
        } else {
            req.setAttribute("errorMessage", "Failed to add anime");
            req.getRequestDispatcher("WEB-INF/anime/animeAdding.jsp").forward(req, resp);
        }
    }
}
