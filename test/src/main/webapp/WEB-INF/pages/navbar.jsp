<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/carhartl-jquery-cookie-92b7715/jquery.cookie.js"/>"></script>
<style>
    .navbarli {
        list-style-type: none;
        margin: 10px; /*расстояние между пунктами по высоте*/
    }
</style>



<nav class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">
    <a class="navbar-brand" href="#">${name}</a>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto" >
            <li class="nav-item active navbarli">
                <c:url value="/signin" var="url"/>
                    <form method="post" action="${url}">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <button class="btn btn-lg btn-block" type="submit">home</button>
                    </form>
                    <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item active navbarli">
                <c:url value="/choosingBookPage" var="choosingBookPage_url"/>
                <form method="post" action="${choosingBookPage_url}">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">
                    <button class="btn btn-lg btn-block" type="submit">chose book</button>
                </form>
                <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item active navbarli">
                <c:url value="/authors" var="authors_url"/>
                    <form method="post" action="${authors_url}">
                        <input type="hidden" name="login" value="${login}">
                        <input type="hidden" name="password" value="${password}">
                        <button class="btn btn-lg btn-block" type="submit">authors</button>
                    </form>
                <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item active navbarli">
                <c:url value="/companys" var="url"/>
                <form method="post" action="${url}">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">
                    <button class="btn btn-lg btn-block" type="submit">companys</button>
                </form>
                <span class="sr-only">(current)</span>
            </li>
            <li class="nav-item active navbarli">
                <c:url value="/genres" var="authors_url"/>
                <form method="post" action="${authors_url}">
                    <input type="hidden" name="login" value="${login}">
                    <input type="hidden" name="password" value="${password}">
                    <button class="btn btn-lg btn-block" type="submit">genres</button>
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
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
