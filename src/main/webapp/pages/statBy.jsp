<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Museum (Statistic by ${name})</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div class="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <caption><h2>Statistic by ${name}</h2></caption>
    <table border="1" cellpadding="5">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Count of Exhibit</th>
            <th scope="col">Name of ${name}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
        <tr>
            <td scope="col"><c:out value="${item[0]}"/></td>
            <td scope="col"><c:out value="${item[1]}"/></td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
</body>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</html>