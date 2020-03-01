<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select date</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <form id="freeTourguides" method="post" action="/freeTourguides">
        <hr class="bg-dark">
        <caption><h4>${message}</h4></caption>

        <caption><h5>Please select date from</h5></caption>
        <input type="datetime-local" name="from" value="2020-03-03T12:30">

        <caption><h5>Please select date to</h5></caption>
        <input type="datetime-local" name="to" value="2020-03-03T12:30">

        <br>

        <input type="submit" class="btn btn-dark" value="Select"/>

        <hr class="bg-dark">
    </form>
</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>
