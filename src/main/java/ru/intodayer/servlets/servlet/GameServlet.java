package ru.intodayer.servlets.servlet;

import javax.servlet.annotation.WebServlet;
import ru.intodayer.servlets.entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        req.setAttribute("username", user.getUsername());
        req.getRequestDispatcher("pages/game.jsp").forward(req, resp);
    }
}
