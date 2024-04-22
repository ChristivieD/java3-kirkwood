package edu.christivie.java3kirkwood.learnx.controller;

import edu.christivie.java3kirkwood.learnx.data.CourseDAO;
import edu.christivie.java3kirkwood.learnx.models.Course;
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
import java.util.Map;
import java.util.TreeMap;

@WebServlet("/student")
public class StudentDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = Helpers.getUserFromSession(req);
        if(user == null || !user.getPrivileges().equals("student")) {
            session.setAttribute("flashMessageWarning", "You must be logged in as a student to view this content");
            resp.sendRedirect("signin?redirect=student");
            return;
        }
        int limit = 5;
        int offset = 0;
        TreeMap<Course, Instant> enrollments = CourseDAO.getCoursesEnrolled(limit, offset, user.getId());
        req.setAttribute("enrollments", enrollments);
        req.setAttribute("pageTitle", "Student Dashboard");
        req.getRequestDispatcher("WEB-INF/learnx/student.jsp").forward(req, resp);
    }
}
