<%@ page import="ru.intodayer.servlets.entity.UserRating" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.intodayer.servlets.game.GameProcess" %>
<%@ page import="ru.intodayer.servlets.game.BullsAndCows" %>
<%@ page import="javafx.util.Pair" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <tr>
        <th>#</th>
        <th>attempt</th>
        <th>bulls</th>
        <th>cows</th>
    </tr>
    <%
        GameProcess gameProcess = (GameProcess) request.getAttribute("gameProcess");
        List<Pair<String, BullsAndCows>> userAttempts = gameProcess.getUserAttempts();
        for (int i = 0; i < userAttempts.size(); i++) {
            out.println(
                "<tr>" +
                    "<td>" + (i+1) +"</td>" +
                    "<td>" + userAttempts.get(i).getKey() + "</td>" +
                    "<td>" + userAttempts.get(i).getValue().getBulls() + "</td>" +
                    "<td>" + userAttempts.get(i).getValue().getCows() + "</td>" +
                "</tr>"
            );
        }
    %>
</table>
