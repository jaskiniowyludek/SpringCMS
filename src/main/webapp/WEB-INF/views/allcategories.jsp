<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All categories</title>
</head>
<body>

<h1>All categories:</h1>
<ul>
    <c:forEach items="${categories}" var="category">
        <li><b>${category.name}</b>
      <p> See articles in this category: <a href="/showArticlesInCategory/${category.id}">Click!</a></p>
      <p> Delete category: <a href="/deletecategory/${category.id}"
                              onclick="return confirm('Are you sure you want to delete this category?');">Click! </a></p>
            <p>Edit category: <a href="/editcategory/${category.id}">Click!</a> </p></li>
    </c:forEach>
</ul>
<p><a href="/addcategory">Add new category</a> </p>
</body>
</html>
