package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.CourseDAO;
import edu.christivie.java3kirkwood.learnx.models.Course;
import edu.christivie.java3kirkwood.learnx.models.CourseCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/courses")
public class Courses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] categoryParams = req.getParameterValues("category");
        String skillFilter = req.getParameter("skill-level");
        String categoryFilter ="";
        if(categoryParams != null && categoryParams.length > 0) {
            categoryFilter = String.join(",", categoryParams);
        }
        if(categoryFilter == null){
            skillFilter = "";
        }
        // To do: For pagination
        int limit = 5;
        int offset = 0;
        List<Course> courses = CourseDAO.get(limit, offset, categoryFilter, skillFilter);
        List<CourseCategory> categories = CourseDAO.getAllCategories();

        req.setAttribute("courses", courses);
        req.setAttribute("categories", categories);
        req.setAttribute("pageTitle", "Courses");
        req.getRequestDispatcher("WEB-INF/learnx/all-courses.jsp").forward(req, resp);
    }
}
