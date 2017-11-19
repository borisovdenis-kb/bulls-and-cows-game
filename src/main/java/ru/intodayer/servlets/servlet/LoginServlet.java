package ru.intodayer.servlets.servlet;

import javax.servlet.annotation.WebServlet;
import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loginIsFailed", req.getParameter("loginIsFailed"));
        req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect("/gameProcess");
        } else {
            resp.sendRedirect("/login?loginIsFailed=true");
        }
    }
}
