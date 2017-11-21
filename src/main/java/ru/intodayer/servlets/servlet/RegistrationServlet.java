package ru.intodayer.servlets.servlet;

import javax.servlet.annotation.WebServlet;
import javax.persistence.PersistenceException;
import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.entity.UserRating;
import ru.intodayer.servlets.service.UserRatingService;
import ru.intodayer.servlets.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;
    private UserRatingService userRatingService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        userRatingService = new UserRatingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("registrationIsFailed", req.getParameter("registrationIsFailed"));
        req.getRequestDispatcher("pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            User newUser = new User(username, password);
            userService.save(newUser);
            userRatingService.save(new UserRating(null, newUser));
        } catch (PersistenceException e) {
            resp.sendRedirect("/registration?registrationIsFailed=true");
            return;
        }
        resp.sendRedirect("/login");
    }
}
