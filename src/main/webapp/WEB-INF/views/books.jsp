<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
    <h1>All Books</h1>

    <a href="<c:url value="/books/add" />">Add Books</a>

    <c:if test="${not empty books}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li>Title: <c:out value="${book.title}"/></li><button onclick="location.href = 'http://localhost:8080/books/details/${book.id}'">Details</button> <button onclick="location.href = 'http://localhost:8080/books/delete/${book.id}'">Delete</button> <button onclick="location.href = 'http://localhost:8080/books/edit/${book.id}'">Edit</button>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>