<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bulls & Cows</title>

    <!-- Style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

    <style type="text/css">
        <%@include file="../css/base_style.css" %>
    </style>

    <style type="text/css">
        <%@include file="../css/game_style.css" %>
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous">
    </script>

    <script><%@include file="../plugins/jquery-3.2.1.min.js" %></script>
    <script><%@include file="../plugins/jquery.maskedinput.min.js" %></script>
    <script><%@include file="../scripts/game_script.js" %></script>
    <script><%@include file="../scripts/menu_script.js" %></script>
</head>
    <body>
        <div class="header">
            <div class="logo"><span>Bulls & Cows</span></div>
            <div class="user"><span>Hello, ${username}</span></div>
            <div class="logout_wrapper">
                <div class="logout_btn_wrapper">
                    <a href="/login" id="logout_btn">log out</a>
                </div>
            </div>
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
                <button id="start_game_btn" class="btn-primary btn btn-lg">Start game</button>
            </div>
        </div>
    </body>
</html>
