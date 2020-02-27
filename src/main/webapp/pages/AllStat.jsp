<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <div class="list-group list-group-flush ">
        <a href="/statByTechnique"
           class="list-group-item list-group-item-action list-group-item-action list-group-item-dark text-dark">
            Statistic by Technique</a>
        <a href="/statByMaterial"
           class="list-group-item list-group-item-action list-group-item-action list-group-item-dark text-dark">
            Statistic by Material</a>
    </div>

</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>