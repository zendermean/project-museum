<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Excursions</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <hr class="bg-dark">

    <caption>
        <h2 class="float-left ml-5">Excursions</h2>
        <a class="btn btn-dark float-right mr-4" href="/dateExcursions" role="button">Select dates</a>
    </caption>

    <br><br>
    <hr class="bg-dark">

    <table border="1" cellpadding="5" class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Time start</th>
            <th scope="col">Time end</th>
            <th scope="col">Tourguide</th>
            <th scope="col">Rooms</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="excursion" items="${excursionList}">
            <tr>
                <td scope="col"><c:out value="${excursion.name}"/></td>
                <td scope="col"><c:out value="${excursion.time_start}"/></td>
                <td scope="col"><c:out value="${excursion.time_end}"/></td>
                <td scope="col"><c:out value="${excursion.worker.name}"/>
                    <c:out value="${excursion.worker.surname}"/></td>
                <td scope="col">
                    <ul style="list-style-type:none;">
                        <c:forEach var="room" items="${excursion.rooms}">
                            <li><c:out value="${room.floor}"/> - <c:out value="${room.number}"/></li>
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