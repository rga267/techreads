<!DOCTYPE html>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
    <h1>Add Book</h1>
    <form:form method="post" modelAttribute="bookForm" action="${pageContext.request.contextPath}/books">
        <form:input path="url" type="text" placeholder="image url"/><br>
        <form:input path="title" type="text" placeholder="Title"/><br>
        <form:input path="author" type="text" placeholder="Author"/><br>
        <form:input path="rating" type="number" min="1" max="5" placeholder="Rating"/><br>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>