<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>
<h1>All authors:</h1>
<ul>
    <c:forEach items="${authors}" var="author">
        <li> <b>${author.firstName} ${author.lastName}</b>
            <p> Delete author: <a href="/deleteauthor/${author.id}"
                                    onclick="return confirm('Are you sure you want to delete this author?');">Click! </a></p>
            <p>Edit author: <a href="/editauthor/${author.id}">Click!</a> </p></li>
        </li>
    </c:forEach>
</ul>
<p><a href="/addauthor">Add new author</a> </p>
</body>
</html>
