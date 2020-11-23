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
    <link href="<c:url value="/resources/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.min.css"/>" rel="stylesheet" type="text/css"/>

<%--    todo make select good--%>



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

                    <input type="hidden" value="" name="author" id="author">
                    <label for="author"></label>
                    <select class="form-group form-control" id="authorss" multiple  onclick="$('#author').val($('#authorss').val())">
                        <option value=""></option>
                        <c:forEach items="${authors}" var="author">
                            <option value="${author.authorId}:${author.authorName}"><c:out value="${author.authorName}"/></option>
                        </c:forEach>
                    </select>

                    <input type="hidden" value="" name="genre" id="genre">
                    <label for="genreId"></label>
                    <select class="form-group form-control" name="genress" multiple id="genreId" onclick="$('#genre').val($('#genreId').val())">
                    <option value=""></option>
                        <c:forEach items="${genres}" var="genre">
                            <option value="${genre.id}:${genre.name}"><c:out value="${genre.name}"/></option>
                        </c:forEach>
                    </select>

<%--                    <label for="newBook" class="sr-only">author</label>--%>
<%--                    <input type="text" name="name" id="newBook" class="form-group mb-2 form-control" height="30px">--%>
                    <button class="btn btn-primary mb-2" type="submit">add</button>
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
            <th>Release Date</th>
            <th>link to file</th>
            <th>Publishing Company</th>
            <th>authors</th>
            <th>genres</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="bookName">
            <tr>
                <td><c:out value="${bookName.bookName}"/></td>
                <td><c:out value="${bookName.bookReleaseDate}"/></td>
                <td><c:out value="${bookName.bookLinkToFile}"/></td>
                <td><c:out value="${bookName.publishingCompany.name}"/></td>
                <td><c:forEach items="${bookName.authors}" var="author">|<c:out value="${author.authorName}"/>|</c:forEach> </td>
                <td><c:forEach items="${bookName.genres}" var="genre">|<c:out value="${genre.name}"/>|</c:forEach> </td>
                <td>
                    <c:url value="/deleteBook" var="updateUrl"/>
                    <form action="${updateUrl}" method="post" class="form-inline">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <input type="hidden" name="bookName" value="${bookName.bookName}">
                        <input type="hidden" name="bookId" value="${bookName.bookId}">
                        <input type="hidden" name="bookCompanyId" value="${bookName.bookCompanyId}">
                        <input type="hidden" name="bookLinkToFile" value="${bookName.bookLinkToFile}">
                        <button class="btn btn-primary mb-2" type="submit" >delete</button>
                    </form>
                </td>
            </tr>
            <tr>
                <c:url value="/updateBook" var="updateUrl"/>
                <form action="${updateUrl}" method="post" class="form-inline">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">
                    <input type="hidden" name="bookId" value="${bookName.bookId}">
                    <td>
                        <input type="text" value="${bookName.bookName}" name="bookName" id="name" class="form-group mb-2 form-control" height="30px">
                    </td>
                    <td>
                        <input type="text" value="${bookName.bookReleaseDate}" name="bookReleaseDate" id="releaseDate" class="form-group mb-2 form-control" height="30px">
                    </td>
                    <td>
                        <input type="text" value="${bookName.bookLinkToFile}" name="bookLinkToFile" id="bookLink" class="form-group mb-2 form-control" height="30px">
                    </td>
                    <td>
<%--                        <input type="text" value="${bookName.publishingCompany.name}" name="bookCompanyId" id="bookCompany" class="form-group mb-2 form-control" height="30px">--%>
                        <select class="form-group form-control" name="company" id="bookCompanyId">
                            <option value=""></option>
                            <c:forEach items="${companys}" var="company">
                                <option value="${company.id}:${company.name}"><c:out value="${company.name}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                    <input type="hidden" value="" name="author" id="author">
                        <label for="author"></label>
                        <select class="form-group form-control" id="authorss" multiple  onclick="$('#author').val($('#authorss').val())">
                            <option value=""></option>
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.authorId}:${author.authorName}"><c:out value="${author.authorName}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="hidden" value="" name="genre" id="genre">
                        <label for="genreId"></label>
                        <select class="form-group form-control" name="genress" multiple id="genreId" onclick="$('#genre').val($('#genreId').val())">
                            <option value=""></option>
                            <c:forEach items="${genres}" var="genre">
                                <option value="${genre.id}:${genre.name}"><c:out value="${genre.name}"/></option>
                            </c:forEach>
                    </select>
                    </td>
                    <td>
                        <button class="btn btn-primary mb-2" type="submit" >update</button>
                    </td>
                </form>
<%--                <td>--%>
<%--                    <form>--%>
<%--                        <select class="form-group form-control" name="author">--%>
<%--                            <option value=""></option>--%>
<%--                            <c:forEach items="${authors}" var="author">--%>
<%--                                <option value="${author.authorId}:${author.authorName}"><c:out value="${author.authorName}"/></option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        <input name="bookId" value="${book.bookId}" type="hidden">--%>
<%--                        <c:url value="/deleteBookAuthor" var="deleteBookAuthor"/>--%>
<%--                        <button formaction="${deleteBookAuthor}" class="btn btn-primary mb-2" type="submit" >delete</button>--%>
<%--                        <c:url value="/addBookAuthor" var="addBookAuthor"/>--%>
<%--                        <button formaction="${addBookAuthor}" class="btn btn-primary mb-2" type="submit" >add</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form>--%>
<%--                        <select class="form-group form-control" name="genre">--%>
<%--                            <option value=""></option>--%>
<%--                            <c:forEach items="${genres}" var="genre">--%>
<%--                                <option value="${genre.id}:${genre.name}"><c:out value="${genre.name}"/></option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        <input  name="bookId" value="${book.bookId}" type="hidden">--%>
<%--                        <c:url value="/deleteBookGenre" var="deleteBookGenre"/>--%>
<%--                        <button formaction="${deleteBookGenre}" class="btn btn-primary mb-2" type="submit" >delete</button>--%>
<%--                        <c:url value="/addBookGenre" var="addBookGenre"/>--%>
<%--                        <button formaction="${addBookGenre}" class="btn btn-primary mb-2" type="submit" >add</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
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
<script src="<c:url value="/resources/jquery-3.5.1.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.min.js"/>"></script>
<script>
    // $('form').submit(function(event) {
    //     event.preventDefault();
    //
    //     var values = $(this).find('select').val();
    //     if (values.length > 0) {
    //         $.get( "/prodazha", { "rooms": values.join() } );
    //     }
    // })

    // $(document).ready(function() {
    //     $('select').onclick(function (){
    //
    //     })
    //     let select = $('.mdb-select');
    //     select.materialSelect();
    // });
</script>
<script>window.jQuery || document.write('<script src="<c:url value="/resources/jquery-3.5.1.min.js"/>"><\/script>')</script><script src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
