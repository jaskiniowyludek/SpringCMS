<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All drafts</title>
</head>
<body>
<c:import url="/WEB-INF/views/fragments/header.jsp"/>
<p><a href="/addDraft">Add draft</a> </p>
<h1>All drafts: </h1>
<ul>
    <c:forEach items="${drafts}" var="draft">
        <li> ${draft.title}
        <p>${draft.content}</p></li>
        <p>Edit draft: <a href="/editDraft/${draft.id}">Click!</a> </p>
        <p>Delete draft: <a href="/deleteDraft/${draft.id}"
                              onclick="return confirm('Are you sure you want to delete this draft?');">Click!</a> </p>

    </c:forEach>
</ul>
</body>
</html>
