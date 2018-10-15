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
            <form:errors path="title"/>
    Content of an article: <form:textarea path="content"/>
            <form:errors path="content"/>
    Author: <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName"/>
            <form:errors path="author"/>
    Categories: <form:checkboxes path="categories" items="${categories}" multiple="true" itemLabel="name" itemValue="id"/>
                <form:errors path="categories"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
