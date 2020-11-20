<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Authors</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v4.1.1">
    <link href="<c:url value="/resources/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/jquery-3.5.1.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"/>"></script>
    <link href="<c:url value="/resources/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.min.css"/>" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.min.js"/>"></script>
<%--    todo make select good--%>


    <script>

    </script>
</head>
<body>
<%@include file="navbar.jsp"%>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <c:url value="/addBook" var="updateUrl"/>
                <form action="${updateUrl}" method="post" class="form-inline">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">

                    <label for="bookName" class="sr-only">name</label>
                    <input type="text" name="bookName" id="bookName" class="form-group mb-2 form-control" height="30px">

                    <label for="bookReleaseDate" class="sr-only">release date</label>
                    <input type="date" name="bookReleaseDate" id="bookReleaseDate" class="form-group mb-2 form-control" height="30px">

                    <label for="bookLinkToFile" class="sr-only">link</label>
                    <input type="text" name="bookLinkToFile" id="bookLinkToFile" class="form-group mb-2 form-control" height="30px">

                    <label for="bookCompanyId" class="sr-only">company</label>
<%--                    <input type="text" name="bookCompanyId" id="bookCompanyId" class="form-group mb-2 form-control" height="30px">--%>
                    <select class="form-group form-control" name="company" id="bookCompanyId">
                        <option value=""></option>
                        <c:forEach items="${companys}" var="company">
                            <option value="${company.id}:${company.name}"><c:out value="${company.name}"/></option>
                        </c:forEach>
                    </select>

                    <label for="authorId"></label>
                    <select class="form-group form-control" name="author" id="authorId">
                        <option value=""></option>
                        <c:forEach items="${authors}" var="author">
                            <option value="${author.authorId}:${author.authorName}"><c:out value="${author.authorName}"/></option>
                        </c:forEach>
                    </select>

                    <label for="genreId"></label>
                    <select class="form-group form-control" name="genre" id="genreId">
                    <option value=""></option>
                        <c:forEach items="${genres}" var="genre">
                            <option value="${genre.id}:${genre.name}"><c:out value="${genre.name}"/></option>
                        </c:forEach>
                    </select>

<%--                    <label for="newBook" class="sr-only">author</label>--%>
<%--                    <input type="text" name="name" id="newBook" class="form-group mb-2 form-control" height="30px">--%>
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
        <thead class="thead-default">
        <tr>
            <th>Book Name</th>
            <th>Publishing Company</th>
            <th>Release Date</th>
            <th>link to file</th>
            <th>authors</th>
            <th>genres</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td><c:out value="${book.bookName}"/></td>
                <td><c:out value="${book.publishingCompany.name}"/></td>
                <td><c:out value="${book.bookReleaseDate}"/></td>
                <td><c:out value="${book.bookLinkToFile}"/></td>
                <td><c:forEach items="${book.authors}" var="author">|<c:out value="${author.authorName}"/>|</c:forEach> </td>
                <td><c:forEach items="${book.genres}" var="genre">|<c:out value="${genre.name}"/>|</c:forEach> </td>
<%--                <td>--%>
<%--                    <c:url value="/updateBooks" var="updateUrl"/>--%>
<%--                    <form action="${updateUrl}" method="post" class="form-inline">--%>
<%--                        <input type="hidden" name="login" value="${login}">--%>
<%--                        <input type="hidden" name="password" value="${password}">--%>
<%--                        <input type="hidden" name="bookId" value="${book.bookId}">--%>
<%--                        <label for="book" class="sr-only">book</label>--%>
<%--                        <input type="text" name="bookName" id="book" class="form-group mb-2 form-control" height="30px">--%>
<%--                        <button class="btn btn-primary mb-2" type="submit" >update</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
                <td>
                    <c:url value="/deleteBook" var="updateUrl"/>
                    <form action="${updateUrl}" method="post" class="form-inline">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <input type="hidden" name="bookName" value="${book.bookName}">
                        <input type="hidden" name="bookId" value="${book.bookId}">
                        <input type="hidden" name="bookCompanyId" value="${book.bookCompanyId}">
                        <input type="hidden" name="bookLinkToFile" value="${book.bookLinkToFile}">
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
<script>window.jQuery || document.write('<script src="<c:url value="/resources/jquery-3.5.1.min.js"/>"><\/script>')</script><script src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
