<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    Is draft? <form:checkbox path="draft"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
