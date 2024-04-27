package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.data.AnimeDAO;
import edu.christivie.java3kirkwood.anime.models.Anime;
import edu.christivie.java3kirkwood.anime.models.Review;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/details")
public class AnimeDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String animeIdParam = req.getParameter("anime_id");
        if (animeIdParam == null || animeIdParam.isEmpty()) {
            // Handle the case where anime_id is missing
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing anime_id parameter");
            return;
        }

        int animeId;
        try {
            // Try to parse the anime_id parameter to an integer
            animeId = Integer.parseInt(animeIdParam);
        } catch (NumberFormatException e) {
            // Handle the case where anime_id is not a valid integer
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid anime_id parameter");
            return;
        }

        // Now animeId should contain a valid integer
        Anime anime = AnimeDAO.getAnimeById(animeId);
        if (anime == null) {
            // Handle the case where no anime is found for the given ID
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Anime not found");
            return;
        }
        List<Review> reviews = AnimeDAO.getReviewsByAnimeId(animeId);


        req.setAttribute("anime", anime);
        req.setAttribute("reviews", reviews);
        req.setAttribute("pageTitle","Home");
        req.getRequestDispatcher("WEB-INF/anime/details.jsp").forward(req,resp);
    }
}
