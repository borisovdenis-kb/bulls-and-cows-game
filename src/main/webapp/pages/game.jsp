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
        <%@include file="../css/game_style.css" %>
    </style>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous">
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous">
    </script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous">
    </script>

    <script><%@include file="../plugins/jquery.maskedinput.min.js" %></script>

    <script><%@include file="../scripts/game_script.js" %></script>
</head>
    <body>
        <div class="header">
            <div class="logo"><span>Bulls & Cows</span></div>
            <div class="user"><span>Hello, ${username}</span></div>
        </div>
        <div class="menu_wrapper">
            <div class="menu">
                <div id="game" class="menu_item">
                    <a><b>GAME</b></a>
                </div>
                <div id="my_attempts" class="menu_item">
                    <a><b>MY ATTEMPTS</b></a>
                </div>
                <div id="top" class="menu_item">
                    <a><b>TOP</b></a>
                </div>
            </div>
        </div>
        <div class="center_content">
            <div class="main_container">
                <div class="left_container">
                    <div class="display flex">
                        <input id="numeric_display" type="text" placeholder="0000">
                    </div>
                    <div class="button_row flex">
                        <div class="numeric_button"><span>1</span></div>
                        <div class="numeric_button"><span>2</span></div>
                        <div class="numeric_button"><span>3</span></div>
                    </div>
                    <div class="button_row flex">
                        <div class="numeric_button"><span>4</span></div>
                        <div class="numeric_button"><span>5</span></div>
                        <div class="numeric_button"><span>6</span></div>
                    </div>
                    <div class="button_row flex">
                        <div class="numeric_button"><span>7</span></div>
                        <div class="numeric_button"><span>8</span></div>
                        <div class="numeric_button"><span>9</span></div>
                    </div>
                    <div class="button_row flex">
                        <div class="cancel_button"><span>←</span></div>
                        <div class="numeric_button"><span>0</span></div>
                        <div class="numeric_button invisible" style="opacity: 0"></div>
                    </div>
                    <div class="check_button_wrapper flex">
                        <%--<div class="check_button">--%>
                            <%--<span></span>--%>
                        <%--</div>--%>
                        <button id="ask_computer_button" type="button" class="btn btn-sm btn-primary">
                            <span>check</span>
                        </button>
                    </div>
                </div>
                <div class="right_container">
                    <span>
                        Computer says
                    </span>
                </div>
            </div>
        </div>
    </body>
</html>
