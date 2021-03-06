<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new author</title>
    <style>
        input. select{
            display: block;
        }
    </style>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
    <form:form method="post" modelAttribute="author">
        First name: <form:input path="firstName" placeholder="Type first name"/>
                    <form:errors path="firstName"/>
        Last name: <form:input path="lastName" placeholder="Type last name"/>
                    <form:errors path="lastName"/>
        <input type="submit" value="Save"/>
    </form:form>
</body>
</html>
