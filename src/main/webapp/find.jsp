<%--
  Created by IntelliJ IDEA.
  User: 38067
  Date: 25.02.2020
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<div id="header">
    <jsp:include page="parts/header.jsp"/>
</div>
<body>
<form id="finder" action="${pageContext.request.contextPath}/findByWorker" method="get">
    <label>Worker name</label>
    <input type="text" name="workerName"/>
    <input type="submit" value="Find"/>
</body>
<div id="footer">
    <jsp:include page="parts/footer.jsp"/>
</div>
</html>