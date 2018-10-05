<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 5/10/18
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles in this category</title>
</head>
<body>

<h1>Articles in this category: </h1>
<ul>
<c:forEach items="${articles}" var="article">
    <li>${article.title}</li>
    <%--<p>${article.content}</p>--%>
</c:forEach>
</ul>
<p>
    <a href="/articles">Come back to all articles</a>
</p>
</body>
</html>
