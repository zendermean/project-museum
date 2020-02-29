<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exhibits by Room</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <hr class="bg-dark">
    <caption><h2>Exhibits by Room</h2></caption>
    <hr class="bg-dark">
    <table width="50%" border="1" cellpadding="5" class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Exhibit</th>
            <th scope="col">Floor</th>
            <th scope="col">Room</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${exhibitList}">
            <tr>
                <td scope="col"><c:out value="${item[0]}"/></td>
                <td scope="col"><c:out value="${item[1]}"/></td>
                <td scope="col"><c:out value="${item[2]}"/></td>
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