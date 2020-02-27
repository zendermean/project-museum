<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP List Exhibit Records</title>
    <jsp:include page="parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="parts/header.jsp"/>
</div>
<body>
<div align="center">
    <caption><h2>List of exhibits</h2></caption>
    <table border="1" cellpadding="5" class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Materials</th>
            <th scope="col">Authors</th>
            <th scope="col">Room</th>
            <th scope="col">Technique</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="exhibit" items="${exhibitList}">
            <tr>
                <td scope="col"><c:out value="${exhibit.id}"/></td>
                <td scope="col"><c:out value="${exhibit.name}"/></td>
                <td scope="col">
                    <c:forEach var="material" items="${exhibit.materials}">
                        <c:out value="${material.name}"/> |
                    </c:forEach>
                </td>
                <td scope="col">
                    <c:forEach var="author" items="${exhibit.authors}">
                        <c:out value="${author.name}"/>
                        <c:out value="${author.surname}"/> |
                    </c:forEach>
                </td>
                <td scope="col"><c:out value="${exhibit.room.floor}"/> - <c:out value="${exhibit.room.number}"/></td>
                <td scope="col"><c:out value="${exhibit.technique.name}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div id="footer">
    <jsp:include page="parts/footer.jsp"/>
</div>
</body>
</html>