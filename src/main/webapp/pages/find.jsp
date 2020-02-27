<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Exhibits by Worker</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <br>
    <form id="finder" action="/findByWorker" method="post">
        <label>Worker name</label>
        <input type="text" name="workerName"/>
        <input type="submit" value="Find"/>
    </form>
    <br>
</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>