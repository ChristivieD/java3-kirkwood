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
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@WebServlet("/comingSoon")
public class AnimeComing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputFilter = req.getParameter("inputFilter");
        int limit = 7;
        HttpSession session1 = req.getSession();
        Integer totalAnime = (Integer) session1.getAttribute("totalAnime");
        if(totalAnime == null){
            totalAnime =AnimeDAO.getAnimeCount();
            session1.setAttribute("totalAnime", totalAnime);
        }
        int totalPages = totalAnime/limit;
        if(totalAnime % limit != 0){
            totalPages ++;
        }
        String pageStr = req.getParameter("page");
        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        } catch (NumberFormatException e){

        }
        if(page < 1){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }

        int offset = (page -1) * limit;
        int pageLinks = 5;
        int beginPage = page / pageLinks * pageLinks > 0 ? page / pageLinks * pageLinks : 1;
        int endPage = beginPage + pageLinks - 1 > totalPages ? totalPages : beginPage + pageLinks - 1;
        List<Anime> animes = AnimeDAO.getAnimes(limit, offset, "", "");

        List<Anime> filteredAnimes = new ArrayList<>();

        if (inputFilter != null && !inputFilter.isEmpty()) {
            for (Anime anime : animes) {
                // Perform filtering based on inputFilter
                if (anime.getTitle().toLowerCase().contains(inputFilter.toLowerCase())) {
                    filteredAnimes.add(anime);
                }
            }
        } else {
            // If no filter is applied, use all animes
            filteredAnimes.addAll(animes);
        }

        List<AnimeGenre> genres = AnimeDAO.getAllGenres();
        HttpSession session = req.getSession();
        User userFromSession = (User) session.getAttribute("activeUser");
        if (userFromSession != null || !userFromSession.getPrivileges().equals("premium")) {
            TreeMap<Anime, Instant> animeGenre = AnimeDAO.getAnimeGenre(limit, offset, "", "");
            req.setAttribute("animeGenre", animeGenre);
        }
        req.setAttribute("beginPage", beginPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page",page);
        req.setAttribute("animes", animes);
        req.setAttribute("genres", genres);
        req.setAttribute("pageTitle","Home");
        req.getRequestDispatcher("WEB-INF/anime/coming-soon.jsp").forward(req,resp);
    }
}
