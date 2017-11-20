<%@ page import="ru.intodayer.servlets.entity.UserRating" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RATING</title>

    <!-- Styles -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

    <style type="text/css">
        <%@include file="../css/game_style.css" %>
    </style>

    <style type="text/css">
        <%@include file="../css/rating_style.css" %>
    </style>

    <!-- Script -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous">
    </script>
    <script><%@include file="../scripts/menu_script.js" %></script>

</head>
<body>
    <div class="header">
        <div class="logo"><span>Bulls & Cows</span></div>
        <div class="user"><span>Hello, ${username}</span></div>
        <div class="logout_wrapper"><button class="logout btn-default btn btn-sm">log out</button></div>
    </div>
    <div class="menu_wrapper">
        <div class="menu">
            <div id="game" class="menu_item">
                <a href="/game"><b>GAME</b></a>
                <div class="bottom_line"></div>
            </div>
            <div id="rating" class="menu_item">
                <a href="/rating"><b>RATING</b></a>
                <div class="bottom_line"></div>
            </div>
        </div>
    </div>

    <div class="center_content">
        <div class="main_container">
            <table>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Average amount of attempts</th>
                </tr>
                <%
                    List<UserRating> userRecords = (List<UserRating>) request.getAttribute("userRatings");
                    for (int i = 0; i < userRecords.size(); i++) {
                        out.println(
                            "<tr>" +
                                "<td>" + (i+1) +"</td>" +
                                "<td>" + userRecords.get(i).getUser().getUsername() + "</td>" +
                                "<td>" + userRecords.get(i).getAvgAttemptAmount() + "</td>" +
                            "</tr>"
                        );
                    }
                %>
            </table>
        </div>
    </div>
</body>
</html>
