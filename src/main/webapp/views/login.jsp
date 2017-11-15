<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Styles -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">


    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css" type="text/css">--%>
    <%--<link rel="stylesheet" href="<c:url value="css/login_style.css"/>" type="text/css">--%>
    <style type="text/css">
        <%@include file="../css/login_style.css" %>
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

    <title>Login</title>
</head>
    <body>
        <div class="wrapper">
            <h2>
                Login
            </h2>
            <form method="post">
                <input placeholder="username" type="text" name="username">
                <input placeholder="password" type="password" name="password"><br/>
                <input type="submit" value="Login">
            </form>
            <p>
                Don't have an account yet? <a href="/registration">create an account</a>
            </p>
        </div>
    </body>
</html>