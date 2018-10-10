<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Articles</title>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<h1>All articles:</h1>
<ul>
    <c:forEach items="${articles}" var="article">
        <li>
            <b>${article.title}</b> ${article.author.firstName} ${article.author.lastName}, created: ${article.created}
            <p>${article.content}</p>
            <p><b>Categories:</b> <c:forEach items="${article.categories}" var="category">
                ${category.name},
            </c:forEach> </p>
            <p>Edit article: <a href="/editarticle/${article.id}">Click!</a> </p>
            <p>Delete article: <a href="/deletearticle/${article.id}">Click!</a> </p>
        </li>
    </c:forEach>
</ul>
<p><a href="/addarticle">Add new article</a> </p>
</body>
</html>
