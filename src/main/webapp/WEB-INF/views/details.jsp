<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
    <h1>Book Details</h1>

    <img style="max-height:150px; max-width:150px;" src="<c:out value="${book.url}"/>"/>
    <li>Title: <c:out value="${book.title}"/></li>
    <li>Author: <c:out value="${book.author}"/></li>
    <li>Rating: <c:out value="${book.rating}"/></li>

</body>
</html>