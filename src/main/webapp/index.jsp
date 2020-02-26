<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP List Exhibit Records</title>
    <script src="style/bootstrap-4.4.1-dist/css/bootstrap.css"></script>
    <script src="style/bootstrap-4.4.1-dist/js/bootstrap.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<div id="header">
    <jsp:include page="parts/header.jsp"/>
</div>
<body>
<div align="center">
    <table border="1" cellpadding="5" class="table">
        <caption><h2>List of exhibits</h2></caption>
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