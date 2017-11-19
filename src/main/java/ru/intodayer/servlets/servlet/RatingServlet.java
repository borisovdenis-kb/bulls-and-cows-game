package ru.intodayer.servlets.servlet;

import javax.servlet.annotation.WebServlet;

import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.service.UserRatingService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/rating")
public class RatingServlet extends HttpServlet {

    private UserRatingService userRatingService = new UserRatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        req.setAttribute("username", user.getUsername());
        req.setAttribute("userRatings", userRatingService.getAllUserRatings());
        req.getRequestDispatcher("pages/rating.jsp").forward(req, resp);
    }
}
