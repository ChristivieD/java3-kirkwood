package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.CourseDAO;
import edu.christivie.java3kirkwood.learnx.models.Course;
import edu.christivie.java3kirkwood.learnx.models.CourseCategory;
import edu.christivie.java3kirkwood.learnx.models.User;
import edu.christivie.java3kirkwood.shared.Helpers;
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
        HttpSession session = req.getSession();
        Integer totalCourses = (Integer)session.getAttribute("totalCourses");
        if(totalCourses == null){
            totalCourses = CourseDAO.getCourseCount();
            session.setAttribute("totalCourses", totalCourses);
        }
        int limit = 2;
        int totalPages = totalCourses/limit;
        if(totalCourses % limit != 0){
            totalPages ++;
        }

        String pageStr = req.getParameter("page");
        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        } catch(NumberFormatException e){

        }
        if(page < 1){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }

        int offset = (page - 1) * limit;

        int pageLinks = 5;
        int beginPage = page / pageLinks * pageLinks > 0 ? page / pageLinks * pageLinks : 1;
        int endPage = beginPage + pageLinks - 1 > totalPages ? totalPages : beginPage + pageLinks - 1;

        List<Course> courses = CourseDAO.get(limit, offset, categoryFilter, skillFilter);
        List<CourseCategory> categories = CourseDAO.getAllCategories();

        User userFromSession = Helpers.getUserFromSession(req);
        if(userFromSession != null) {
            TreeMap<Course, Instant> enrollments = CourseDAO.getCoursesEnrolled(limit, offset, userFromSession.getId());
            req.setAttribute("enrollments", enrollments);
        }

        req.setAttribute("beginPage", beginPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("courses", courses);
        req.setAttribute("categories", categories);
        req.setAttribute("pageTitle", "Courses");
        req.getRequestDispatcher("WEB-INF/learnx/all-courses.jsp").forward(req, resp);
    }
}
