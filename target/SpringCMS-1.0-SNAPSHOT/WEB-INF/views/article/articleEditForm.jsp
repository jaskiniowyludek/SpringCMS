<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit article</title>
    <style>
        input. select{
            display: block;
        }
    </style>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
    <form:form method="post" modelAttribute="article">
        <form:hidden path="id"/>
        <input type="hidden" name="created" value="${created}">
       Title:                   <form:input path="title"/>
                                <form:errors path="title"/>
        Content of the article: <form:textarea path="content"/>
                                <form:errors path="content"/>
        Author: <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName"/>
                <form:errors path="author"/>
        Categories of this article: <c:forEach items="${categoriesInArticle}" var="catArt">
        ${catArt.name}<input type="checkbox" value="${catArt.id}" checked>
    </c:forEach>
        Add more categories: <form:checkboxes path="categories" items="${categories}" multiple="true" itemLabel="name" itemValue="id"/>
                            <form:errors path="categories"/>
        <input type="submit" value="Save">
    </form:form>

</body>
</html>
