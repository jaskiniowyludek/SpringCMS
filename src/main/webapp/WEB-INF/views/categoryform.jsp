<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ewelina
  Date: 9/10/18
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new category</title>
    <style>
        input. select{
            display: block;
        }
    </style>
</head>
<body>
<form:form modelAttribute="category" method="post">
   Name: <form:input path="name" placeholder="Type name"/>
    Description: <form:textarea path="description" rows="10" cols="20"/>
    Articles: <form:select path="articles" items="${articles}" itemLabel="title" itemValue="id" multiple="true"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
