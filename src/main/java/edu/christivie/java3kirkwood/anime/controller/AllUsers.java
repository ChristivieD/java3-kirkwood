package edu.christivie.java3kirkwood.anime.controller;

import edu.christivie.java3kirkwood.anime.models.Users;
import edu.christivie.java3kirkwood.anime.data.UsersDAO;
import edu.christivie.java3kirkwood.learnx.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class AllUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> user = UsersDAO.getAll();
        user.forEach(System.out::println);
        req.setAttribute("user", user);
        req.setAttribute("pageTitle","All Users");
        req.getRequestDispatcher("WEB-INF/anime/all-users.jsp").forward(req,resp);
    }
}
