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
<div class="card border-dark mb-3 pb-3" style="max-width: 18rem; margin: 15px auto auto;">
    <div class="card-header">Exhibit: ${exhibit.name}</div>
    <div class="card-body text-dark">
        <h6 class="card-title">Authors:</h6>
        <p class="card-text">
        <ul>
            <c:forEach var="author" items="${exhibit.authors}">
                <li>
                    <c:out value="${author.name}"/>
                    <c:out value="${author.surname}"/>
                </li>
            </c:forEach>
        </ul>
        </p>
    </div>
    <div class="card-footer bg-transparent"><p>Materials:</p>
        <ul>
            <c:forEach var="material" items="${exhibit.materials}">
                <li>
                    <c:out value="${material.name}"/>
                </li>
            </c:forEach>
        </ul>
        <hr>
        <p>Technique: ${exhibit.technique.name}</p>
    </div>
</div>
</body>
</html>
