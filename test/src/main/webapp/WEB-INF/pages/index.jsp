<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>EBook-Sign in</title>
    <link href="<c:url value="/resources/signin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>

    <style>

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
</head>
<body class="text-center">
    <c:url value="/signin" var="url"/>
    <form class="form-signin" action="${url}" method="post">
        <img class="mb-4" src="<c:url value="/resources/bootstrap-icons-1.1.0/book.svg"/>" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="login" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>

        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

        <label for="inputNameInSystem" class="sr-only">name in system</label>
        <input name="name" type="text" id="inputNameInSystem" class="form-control" placeholder="name in system" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
<%--        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>--%>

        <p class="mt-5 mb-3 text-muted">&copy; ${test}</p>
    </form>
</body>
</html>
