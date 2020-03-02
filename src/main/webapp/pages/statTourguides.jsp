<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Total excursions by each tourguide</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <div class="list-group list-group-flush ">
        <a href="/statByTourguides"
           class="list-group-item list-group-item-action list-group-item-action list-group-item-dark text-dark">
            Statistic by Tourguides</a>
        <a href="#"
           class="list-group-item list-group-item-action list-group-item-action list-group-item-dark text-dark">
            Total working time of each tourguide by the period</a>
    </div>
</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>