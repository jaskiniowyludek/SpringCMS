<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<p><a href="/addauthor">Add new author</a> </p>
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

</body>
</html>
