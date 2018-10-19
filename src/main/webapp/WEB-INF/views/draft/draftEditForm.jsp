<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit draft</title>
</head>
<body>

<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<form:form method="post" modelAttribute="article">
    Title: <form:input path="title"/>
    <form:errors path="title"/>
    Content: <form:textarea path="content"/>
    <form:errors path="content"/>
    <input type="hidden" name="draft" value="true">
    <input type="submit" value="Save">
</form:form>
</body>
</html>
