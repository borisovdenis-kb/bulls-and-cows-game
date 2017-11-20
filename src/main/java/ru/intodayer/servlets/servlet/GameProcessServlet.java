package ru.intodayer.servlets.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.intodayer.servlets.entity.User;
import ru.intodayer.servlets.entity.UserAttempt;
import ru.intodayer.servlets.game.BullsAndCows;
import ru.intodayer.servlets.game.GameProcess;
import ru.intodayer.servlets.game.exception.ValidationException;
import ru.intodayer.servlets.service.UserAttemptService;
import ru.intodayer.servlets.service.UserRatingService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/gameProcess")
public class GameProcessServlet extends HttpServlet {

    private ObjectMapper jsonMapper;
    private UserAttemptService userAttemptService;
    private UserRatingService userRatingService;

    @Override
    public void init() throws ServletException {
        jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        userAttemptService = new UserAttemptService();
        userRatingService = new UserRatingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        GameProcess gameProcess = (GameProcess) session.getAttribute("gameProcess");

        resp.setContentType("application/javascript");

        if (gameProcess != null) {
            String userNumber = req.getParameter("number");
            if (userNumber != null) {
                try {
                    BullsAndCows bullsAndCows = gameProcess.handleUserAttempt(userNumber);
                    req.setAttribute("gameProcess", gameProcess);
                    resp.getWriter().write(jsonMapper.writeValueAsString(gameProcess));

                    if (bullsAndCows.getBulls() == 4) {
                        updateUserAttemptAndRecord(user, gameProcess);
                        gameProcess = null;
                        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                    }
                    session.setAttribute("gameProcess", gameProcess);
                    req.getRequestDispatcher("pages/userAttempts.jsp").forward(req, resp);
                } catch (ValidationException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameProcess gameProcess = new GameProcess();
        System.out.println(gameProcess.getSecretNumber());
        session.setAttribute("gameProcess", gameProcess);

        req.getRequestDispatcher("html/keyboard.html").forward(req, resp);
    }


    private void updateUserAttemptAndRecord(User user, GameProcess gameProcess) {
        userAttemptService.save(
            new UserAttempt(gameProcess.getUserAttempts().size(), user)
        );
        Integer avgAttemptAmount = userAttemptService.getAvgAttemptAmount(user);
        userRatingService.updateAvgAttemptAmount(user, avgAttemptAmount);
    }
}
