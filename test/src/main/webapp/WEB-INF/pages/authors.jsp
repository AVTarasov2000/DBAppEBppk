<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authors</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v4.1.1">
    <link href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/main.css"/>" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<%@include file="navbar.jsp"%>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <c:url value="/addAuthor" var="updateUrl"/>
                <form action="${updateUrl}" method="post" class="form-inline">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">
                    <label for="author" class="sr-only">author</label>
                    <input type="text" name="authorName" id="newAuthor" class="form-group mb-2 form-control" height="30px">
                    <button class="btn btn-primary mb-2" type="submit" >add</button>
                </form>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-end">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>
<main role="main">
    <table class="table table-inverse">
        <tbody>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.name}</td>
                <td>
                    <c:url value="/updateAuthor" var="updateUrl"/>
                    <form action="${updateUrl}" method="post" class="form-inline">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <input type="hidden" name="authorId" value="${author.id}">
                        <label for="author" class="sr-only">login</label>
                        <input type="text" name="authorName" id="author" class="form-group mb-2 form-control" height="30px">
                        <button class="btn btn-primary mb-2" type="submit" >update</button>
                    </form>
                </td>
                <td>
                    <c:url value="/deleteAuthor" var="updateUrl"/>
                    <form action="${updateUrl}" method="post" class="form-inline">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <input type="hidden" name="authorName" value="${author.name}">
                        <input type="hidden" name="authorId" value="${author.id}">
                        <button class="btn btn-primary mb-2" type="submit" >delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
    </div>
</footer>
<script src="<c:url value="/resources/jquery-3.5.1.min.js"/>" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="<c:url value="/resources/jquery-3.5.1.min.js"/>"><\/script>')</script><script src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
