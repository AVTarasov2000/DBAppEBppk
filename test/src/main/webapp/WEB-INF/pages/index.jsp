<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Signin Template · Bootstrap</title>
<%--    <link href="<c:url value="/resourses/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>--%>
<%--    <link href="<c:url value="/resourses/signin.css"/>" rel="stylesheet" type="text/css"/>--%>


    <!-- Bootstrap core CSS -->
<%--    <link href="resourses/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">--%>


    <style>
        <%@include file="/resourses/bootstrap-4.0.0-dist/css/bootstrap.min.css"%>
        <%@include file="/resourses/signin.css"%>

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
<%--    <link href="resourses/signin.css" rel="stylesheet">--%>
</head>
<body class="text-center">
<form class="form-signin">
<%--    <img class="mb-4" src="resourses/bootstrap-icons-1.1.0/book.svg" alt="" width="72" height="72">--%>
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
</body>
</html>
