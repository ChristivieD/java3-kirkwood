package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.JobListiningDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/jobListing")
public class JobListing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int limit = 20;
        int offset =0;
        String location = req.getParameter("location");
        List<edu.christivie.java3kirkwood.learnx.models.JobListing> jobListings = JobListiningDAO.getAll(limit,offset,location);
        req.setAttribute("jobListings", jobListings);
        req.getRequestDispatcher("/WEB-INF/learnx/jobListing.jsp").forward(req, resp);
    }
}
