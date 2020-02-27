<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exhibit - ${exhibit.name}</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<body>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<div align="left">
    <H1>Exhibit: ${exhibit.name}</H1>
    <H6 class="blockquote-footer">Authors:
        <c:forEach var="author" items="${exhibit.authors}">|
            <c:out value="${author.name}"/>
            <c:out value="${author.surname}"/> |
        </c:forEach>
    </H6>
    <br>
    <p>
        Materials:
        <c:forEach var="material" items="${exhibit.materials}">
            <c:out value="${material.name}"/> ;
        </c:forEach>
    </p>
    <p>
        Technique: ${exhibit.technique.name}
    </p>
    <div id="footer">
        <jsp:include page="../parts/footer.jsp"/>
    </div>
</div>
</body>
</html>
