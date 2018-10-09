<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
    <style>
        input. select{
            display: block;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    Description: <form:textarea path="description"/>
    Articles: <form:checkboxes path="articles" items="${articles}" itemValue="id" itemLabel="title"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
