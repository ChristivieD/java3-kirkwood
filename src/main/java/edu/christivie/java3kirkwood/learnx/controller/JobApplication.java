package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.JobListiningDAO;
import edu.christivie.java3kirkwood.learnx.models.JobListing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/application")
public class JobApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobIdParam = req.getParameter("job_id");
        if(jobIdParam == null || jobIdParam.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing job_id parameter");
            return;
        }
        int jobId ;
        try{
            jobId = Integer.parseInt(jobIdParam);
        } catch (NumberFormatException e){
            resp.sendRedirect("jobListing");
            return;
        }

        JobListing jobListing = JobListiningDAO.getJobListingId(jobId);
        if(jobListing == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Job not found");
            return;
        }
        req.setAttribute("jobListing", jobListing);
        req.setAttribute("pageTitle","Home");
        req.getRequestDispatcher("WEB-INF/learnx/application.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int jobId = Integer.parseInt(req.getParameter("inputjobId"));
        String firstName = req.getParameter("InputName");
        String lastName = req.getParameter("InputLastName");
        String email = req.getParameter("InputEmail");
//        double desiresSalary = Double.parseDouble(req.getParameter("InputSalary"));
        Instant startingDate = Instant.parse(req.getParameter("InputDate"));
        Map<String, String> results = new HashMap<>();
        results.put("jobId", String.valueOf(jobId));
        results.put("firstName", firstName);
        results.put("lastName", lastName);
        results.put("email", email);
        results.put("staringDate", String.valueOf(startingDate));

        req.getRequestDispatcher("WEB-INF/learnx/application.jsp").forward(req,resp);

    }
}
