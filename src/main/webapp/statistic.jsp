<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Museum</title>
</head>

<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Statistic by Technique</h2></caption>
        <tr>
            <th>Count of Exhibit</th>
            <th>Name of Technique</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td><c:out value="${item[0]}"/></td>
                <td><c:out value="${item[1]}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>