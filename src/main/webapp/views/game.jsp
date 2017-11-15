<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bulls & Cows</title>

    <!-- Style -->
    <style type="text/css">
        <%@include file="../css/game_style.css" %>
    </style>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous">
    </script>
    <script>
        <%@include file="../plugins/jquery.maskedinput.min.js" %>
    </script>
    <script>
        <%@include file="../scripts/game_script.js" %>
    </script>
</head>
    <body>
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
                        <div class="numeric_button invisible" style="opacity: 0"></div>
                        <div class="numeric_button"><span>0</span></div>
                        <div class="numeric_button invisible" style="opacity: 0"></div>
                    </div>
                    <div class="check_button_wrapper flex">
                        <div class="check_button"></div>
                    </div>
                </div>
                <div class="right_container">

                </div>
            </div>
        </div>
    </body>
</html>
