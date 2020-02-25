<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP List Exhibit Records</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of exhibits</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Materials</th>
            <th>Authors</th>
            <th>Room</th>
            <th>Technique</th>
        </tr>
        <c:forEach var="exhibit" items="${exhibitList}">
            <tr>
                <td><c:out value="${exhibit.id}"/></td>
                <td><c:out value="${exhibit.name}"/></td>
                <td>
                    <c:forEach var="material" items="${exhibit.materials}">
                        <c:out value="${material.name}"/> |
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="author" items="${exhibit.authors}">
                        <c:out value="${author.name}"/>
                        <c:out value="${author.surname}"/> |
                    </c:forEach>
                </td>
                <td><c:out value="${exhibit.room.floor}"/> - <c:out value="${exhibit.room.number}"/></td>
                <td><c:out value="${exhibit.technique.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>