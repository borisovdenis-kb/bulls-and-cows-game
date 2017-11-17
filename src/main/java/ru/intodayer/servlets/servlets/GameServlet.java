package ru.intodayer.servlets.servlets;

import ru.intodayer.servlets.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = Persistence
            .createEntityManagerFactory("bullsAndCows")
            .createEntityManager();
        User user = entityManager.find(User.class, 1);
        System.out.println(user);
        req.getRequestDispatcher("views/game.jsp").forward(req, resp);
    }
}
