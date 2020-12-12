<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Main</title>


    <!-- Bootstrap core CSS -->
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
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/main.css"/>" rel="stylesheet">
</head>
<body>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <ul class="navbar-nav mr-auto" >
                <li class="nav-item active navbarli">
                    <c:url value="/tenBest" var="tenBest_url"/>
                    <form method="post" action="${tenBest_url}">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <button class="btn btn-lg btn-block" type="submit">ten best</button>
                    </form>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item active navbarli">
                    <c:url value="/books" var="books_url"/>
                    <form method="post" action="${books_url}">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <button class="btn btn-lg btn-block" type="submit">all books</button>
                    </form>
                    <span class="sr-only">(current)</span>
                </li>
            </ul>
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
<jsp:include page="navbar.jsp"/>

<main role="main">
    <div class="row">
    <c:forEach items="${books}" var="book">

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">${book.bookName}</text></svg>
                <div class="card-body">
                    <p class="card-text">
                        publishingCompany: ${book.publishingCompany.name}<br>
                        releaseDate: ${book.bookReleaseDate}<br>
                        <c:if test="${book.authors.size()}>0">
                        authors: <c:forEach items="${book.authors}" var="author"><c:out value="${author.authorName}"/>,</c:forEach><br>
                        </c:if>
                        <c:if test="${book.authors.size()}>0">
                        genres: <c:forEach items="${book.genres}" var="genre"><c:out value="${genre.name}"/>,</c:forEach><br>
                        </c:if>
                    </p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Read</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Mark</button>
                        </div>
                        <small class="text-muted">${book.middleRating}</small>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
<%--    <table class="table table-inverse">--%>
<%--        <thead class="thead-default">--%>
<%--        <tr>--%>
<%--            <th>Book Name</th>--%>
<%--            <th>Publishing Company</th>--%>
<%--            <th>Release Date</th>--%>
<%--            <th>link to file</th>--%>
<%--            <th>authors</th>--%>
<%--            <th>genres</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${books}" var="book">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${book.bookName}"/></td>--%>
<%--                <td><c:out value="${book.publishingCompany.name}"/></td>--%>
<%--                <td><c:out value="${book.bookReleaseDate}"/></td>--%>
<%--                <td><c:out value="${book.bookLinkToFile}"/></td>--%>
<%--                <td><c:forEach items="${book.authors}" var="author">|<c:out value="${author.authorName}"/>|</c:forEach> </td>--%>
<%--                <td><c:forEach items="${book.genres}" var="genre">|<c:out value="${genre.name}"/>|</c:forEach> </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>

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
