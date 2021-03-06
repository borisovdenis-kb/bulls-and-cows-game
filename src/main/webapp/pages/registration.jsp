<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Styles -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

    <style type="text/css">
        <%@include file="../css/login_style.css" %>
    </style>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous">
    </script>

    <title>Registration</title>
</head>
    <body>
        <div class="wrapper">
            <h2>
                Registration
            </h2>
            <form method="post">
                <input placeholder="username" type="text" name="username">
                <input placeholder="password" type="password" name="password"><br/>
                <input type="submit" value="Create an account">
            </form>
            <p>
                Already have an account? <a href="/login">login</a>
            </p>
        </div>
        <%
            String regIsFailed = (String) request.getAttribute("registrationIsFailed");
            if (regIsFailed != null && regIsFailed.equals("true")) {
                out.println("<h5 class=\"text-center alert-danger btn-lg\"> " +
                        "User with the same username already exist.</h5 >"
                );
            }
        %>
    </body>
</html>
