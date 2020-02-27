<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tourguides</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <hr class="bg-dark">
    <caption><h2>Tourguides</h2></caption>
    <hr class="bg-dark">
    <table border="1" cellpadding="5" class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Excursions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="worker" items="${workerList}">
            <tr>
                <td scope="col"><c:out value="${worker.name}"/></td>
                <td scope="col"><c:out value="${worker.surname}"/></td>
                <td scope="col">
                    <ul style="list-style-type:none;">
                        <c:forEach var="excursion" items="${worker.excursions}">
                            <li><c:out value="${excursion.name}"/></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>