<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Exhibits</title>
    <jsp:include page="parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="parts/header.jsp"/>
</div>
<body>
<div align="center">
    <hr class="bg-dark">
    <caption><h2>List of exhibits</h2></caption>
    <hr class="bg-dark">
    <table border="1" cellpadding="5" class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Materials</th>
            <th scope="col">Authors</th>
            <th scope="col">Room</th>
            <th scope="col">Technique</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="exhibit" items="${exhibitList}">
            <tr onclick="window.location.assign('/exhibit?id=${exhibit.id}');">
                <td scope="col"><c:out value="${exhibit.name}"/></td>
                <td scope="col">
                    <ul style="list-style-type:none;">
                        <c:forEach var="material" items="${exhibit.materials}">
                            <li><c:out value="${material.name}"/></li>
                        </c:forEach>
                    </ul>
                </td>
                <td scope="col">
                    <ul style="list-style-type:none;">
                        <c:forEach var="author" items="${exhibit.authors}">
                            <li>
                                <c:out value="${author.name}"/>
                                <c:out value="${author.surname}"/>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
                <td scope="col"><c:out value="${exhibit.room.floor}"/> - <c:out
                        value="${exhibit.room.number}"/></td>
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