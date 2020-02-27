<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Museum exhibit - ${exhibit.name}</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<body>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<H1>exhibit - ${exhibit.name}</H1>
<p>${ser}</p>
<p>${req}</p>
<H3>Authors:
    <c:forEach var="author" items="${exhibit.authors}">
        <c:out value="${author.name}"/>
        <c:out value="${author.surname}"/> |
    </c:forEach>
</H3>
<p>
    Materials:
    <c:forEach var="material" items="${exhibit.materials}">
        <c:out value="${material.name}"/> |
    </c:forEach>
</p>
<p>
    Technique - ${exhibit.technique.name}
</p>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>
