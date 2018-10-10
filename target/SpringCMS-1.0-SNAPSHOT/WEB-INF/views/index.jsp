<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 10/10/18
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to CMS</title>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<h1>Welcome to CMS!!!</h1>
<h1>The newest articles:</h1>
<ul>
    <c:forEach items="${articles}" var="article">
        <c:set var="content" value="${article.content}"/>
        <c:set var="shortContent" value="${fn:substring(content, 0, 200)}"/>
        <li><b>Title:</b> ${article.title} <b>Created:</b> ${article.created} <b>Content:</b> ${shortContent}...</li>
    </c:forEach>
</ul>
<h2>See categories: </h2>
<ul>
    <c:forEach items="${categories}" var="category">
        <li><a href="/showArticlesInCategory/${category.id}">${category.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
