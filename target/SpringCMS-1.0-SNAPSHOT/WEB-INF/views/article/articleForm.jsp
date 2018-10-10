<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new article</title>
    <style>
        input. select{
            display: block;
        }
    </style>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<form:form method="post" modelAttribute="article">
    Title: <form:input path="title" placeholder="Type title"/>
    Content of an article: <form:textarea path="content"/>
    Author: <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName"/>
    Categories: <form:checkboxes path="categories" items="${categories}" multiple="true" itemLabel="name" itemValue="id"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
