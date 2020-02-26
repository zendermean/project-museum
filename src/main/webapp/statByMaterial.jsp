<%--
  Created by IntelliJ IDEA.
  User: 38067
  Date: 26.02.2020
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Museum</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<div align="center">
    <caption><h2>Statistic by Material</h2></caption>
    <table border="1" cellpadding="5">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Count of Exhibit</th>
            <th scope="col">Name of Material</th>
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
</html>
