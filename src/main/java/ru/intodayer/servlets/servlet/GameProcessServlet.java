package ru.intodayer.servlets.servlet;

import javax.servlet.annotation.WebServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.intodayer.servlets.game.BullsAndCows;
import ru.intodayer.servlets.game.GameProcess;
import ru.intodayer.servlets.game.exception.ValidationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/gameProcess")
public class GameProcessServlet extends HttpServlet {

    private GameProcess gameProcess;
    private ObjectMapper jsonMapper;

    @Override
    public void init() throws ServletException {
        jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean inGameState = (Boolean) session.getAttribute("inGameState");

        resp.setContentType("application/javascript");

        if (inGameState != null && inGameState) {
            String userNumber = req.getParameter("number");
            if (userNumber != null) {
                try {
                    BullsAndCows bullsAndCows = this.gameProcess.handleUserAttempt(userNumber);
                    if (bullsAndCows.getBulls() != 4) {
                        resp.getWriter().write(jsonMapper.writeValueAsString(gameProcess));
                    } else {
                        session.setAttribute("inGameState", false);
                        resp.setStatus(HttpServletResponse.SC_RESET_CONTENT);
                    }
                } catch (ValidationException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        gameProcess = new GameProcess();
        session.setAttribute("inGameState", true);
    }
}
